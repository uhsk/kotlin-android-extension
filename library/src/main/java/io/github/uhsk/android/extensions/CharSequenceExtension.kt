package io.github.uhsk.android.extensions

import io.github.uhsk.android.extensions.utils.ByteArrayBase64Util
import org.apache.commons.codec.binary.Hex
import java.io.File
import java.nio.charset.Charset

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.md5(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().md5().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha1(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha1().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha256(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha256().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.sha512(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toString().toByteArray(charset).hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.base64(charset: Charset = Charsets.UTF_8): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this.toString().toByteArray(charset))

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.asFile(): File = File(this.toString())

/**
 * @since 1.0.0
 * @author sollyu
 */
fun CharSequence.asHexStringToByteArray(): ByteArray = Hex.decodeHex(this.toString())
