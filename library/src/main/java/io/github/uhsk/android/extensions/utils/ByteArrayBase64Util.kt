package io.github.uhsk.android.extensions.utils

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
