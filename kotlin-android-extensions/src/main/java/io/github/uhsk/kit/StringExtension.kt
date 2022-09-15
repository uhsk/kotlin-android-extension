/*
 * Copyright (C) 2022. sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.uhsk.kit

import io.github.uhsk.kit.libs.codec.binary.Hex
import io.github.uhsk.kit.utils.ByteArrayBase64Util
import io.github.uhsk.kit.utils.ByteArrayGzipUtil
import io.github.uhsk.kit.utils.ByteArrayHashUtil
import org.apache.commons.lang3.LocaleUtils
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.nio.charset.Charset
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @since 1.0.3
 * @author sollyu
 */
fun String.uuid(charset: Charset = Charsets.UTF_8): CharSequence = this.toByteArray(charset).hash().uuid().toString()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.md5(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().md5().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha1(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha1().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha256(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha256().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.sha512(charset: Charset = Charsets.UTF_8, toLowerCase: Boolean = false): CharSequence = this.toByteArray(charset).hash().sha512().toHexString(toLowerCase)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.base64(charset: Charset = Charsets.UTF_8): ByteArrayBase64Util = ByteArrayBase64Util(bytes = this.toByteArray(charset))

/**
 * @since 1.0.2
 * @author sollyu
 */
fun String.hash(charset: Charset = Charsets.UTF_8): ByteArrayHashUtil = this.toByteArray(charset).hash()

/**
 * @since 1.0.2
 * @author sollyu
 */
fun String.gzip(charset: Charset = Charsets.UTF_8): ByteArrayGzipUtil = this.toByteArray(charset).gzip()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.asHexStringToByteArray(): ByteArray = Hex.decodeHex(this)

/**
 * @since 1.0.2
 * @author sollyu
 * @see StringUtils.abbreviate
 */
fun String.abbreviate(width: Int, abbrevMarker: String = "...", offset: Int = 0): String = StringUtils.abbreviate(this, abbrevMarker, offset, width)

/**
 * @since 1.0.2
 * @author sollyu
 * @see StringUtils.center
 */
fun String.center(size: Int, pad: String = " "): String = StringUtils.center(this, size, pad)

/**
 * @since 1.0.2
 * @author sollyu
 * @see StringUtils.chomp
 */
fun String.chomp(): String = StringUtils.chomp(this)

/**
 * @since 1.0.2
 * @author sollyu
 */
fun String.find(regex: Regex, startIndex: Int = 0) = regex.find(this, startIndex)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun String.toFile(): File = File(this)

/**
 * @since 1.0.2
 * @author sollyu
 * @see LocaleUtils.toLocale
 */
fun String.toLocale(): Locale = LocaleUtils.toLocale(this)

/**
 * @since 1.0.3
 * @author sollyu
 * @see LocaleUtils.toLocale
 */
@Throws(ParseException::class)
fun String.toDate(pattern: String = "yyyy-MM-dd HH:mm:ss", locale: Locale = Locale.ENGLISH): Date? = SimpleDateFormat(pattern, locale).parse(this)
