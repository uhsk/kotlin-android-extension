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

package io.github.uhsk.kit.utils

import io.github.uhsk.kit.utils.crypto.CryptoAesCbc
import io.github.uhsk.kit.utils.crypto.CryptoAesEbc

/**
 * 加密类
 *
 * @author sollyu
 * @date   2022-08-23
 */
class ByteArrayCryptoUtil(private val bytes: ByteArray) {

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun aesCbcPKCS5Padding(): CryptoAesCbc = CryptoAesCbc(bytes, transformation = CryptoAesCbc.Transformation.PKCS5Padding)

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun aesCbcNoPadding(): CryptoAesCbc = CryptoAesCbc(bytes, transformation = CryptoAesCbc.Transformation.NoPadding)

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun aesEbcPKCS5Padding(): CryptoAesEbc = CryptoAesEbc(bytes, transformation = CryptoAesEbc.Transformation.PKCS5Padding)

    /**
     * @since 1.0.8
     * @author sollyu
     */
    fun aesEbcNoPadding(): CryptoAesEbc = CryptoAesEbc(bytes, transformation = CryptoAesEbc.Transformation.NoPadding)

}
