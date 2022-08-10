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

import android.util.Base64
import androidx.annotation.IntDef

/**
 * @author sollyu
 * @date   2022-08-10
 */
class ByteArrayBase64Util(private val bytes: ByteArray) {

    /**
     * @since 1.0.0
     * @author sollyu
     */
    @IntDef(value = [Base64.DEFAULT, Base64.NO_PADDING, Base64.NO_WRAP, Base64.CRLF, Base64.URL_SAFE, Base64.NO_CLOSE])
    @Retention(value = AnnotationRetention.SOURCE)
    annotation class Flags

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun encode(@Flags flags: Int = Base64.DEFAULT): ByteArray {
        return Base64.encode(bytes, flags)
    }

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun encodeToString(@Flags flags: Int = Base64.DEFAULT): String {
        return Base64.encodeToString(bytes, flags)
    }

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun decode(@Flags flags: Int = Base64.DEFAULT): ByteArray {
        return Base64.decode(bytes, flags)
    }

}
