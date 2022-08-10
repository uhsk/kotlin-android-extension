package io.github.uhsk.android.extensions

import io.github.uhsk.android.extensions.utils.ByteArrayBase64Util
import io.github.uhsk.android.extensions.utils.ByteArrayGzipUtil
import io.github.uhsk.android.extensions.utils.ByteArrayHashUtil
import org.apache.commons.codec.binary.Hex

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.md5(toLowerCase: Boolean = false): CharSequence = this.hash().md5().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha1(toLowerCase: Boolean = false): CharSequence = this.hash().sha1().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha256(toLowerCase: Boolean = false): CharSequence = this.hash().sha256().toHexString(toLowerCase)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.sha512(toLowerCase: Boolean = false): CharSequence = this.hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.base64(): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.hash(): ByteArrayHashUtil = ByteArrayHashUtil(bytes = this)

/**
 * @param toLowerCase
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.toHexString(toLowerCase: Boolean = false): CharSequence = Hex.encodeHexString(this, toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun ByteArray.gzip(): ByteArrayGzipUtil = ByteArrayGzipUtil(bytes = this)
