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

@file:JvmName(name = "ByteArrayExtension")

package io.github.uhsk.kit

import io.github.uhsk.kit.utils.ByteArrayBase64Util
import io.github.uhsk.kit.utils.ByteArrayGzipUtil
import io.github.uhsk.kit.utils.ByteArrayHashUtil
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
