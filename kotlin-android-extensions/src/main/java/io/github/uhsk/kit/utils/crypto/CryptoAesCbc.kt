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

package io.github.uhsk.kit.utils.crypto

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * @author sollyu
 * @date   2022-08-23
 */
class CryptoAesCbc(private val bytes: ByteArray, transformation: Transformation) {

    enum class Transformation {
        PKCS5Padding, NoPadding
    }

    private val mTransformation: String = when (transformation) {
        Transformation.PKCS5Padding -> "AES/CBC/PKCS5Padding"
        Transformation.NoPadding    -> "AES/CBC/NoPadding"
    }

    /**
     * @since 1.0.8
     * @author sollyu
     */
    private fun generateCipher(key: ByteArray, iv: ByteArray, opMode: Int): Cipher {
        val i = IvParameterSpec(iv)
        val k = SecretKeySpec(key, "AES")
        val c = Cipher.getInstance(mTransformation)
        c.init(opMode, k, i)
        return c
    }

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun decrypt(key: ByteArray, iv: ByteArray): ByteArray {
        return generateCipher(key, iv, opMode = Cipher.DECRYPT_MODE).doFinal(bytes)
    }

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun encrypt(key: ByteArray, iv: ByteArray): ByteArray {
        return generateCipher(key, iv, opMode = Cipher.ENCRYPT_MODE).doFinal(bytes)
    }
}
