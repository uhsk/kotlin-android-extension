package io.github.uhsk.kit.android

import android.content.Intent
import android.os.Build
import java.io.Serializable

/**
 * @since 1.0.14
 */
@Suppress(names = ["DEPRECATION"])
inline fun <reified T : Serializable> Intent.getSerializableCompat(key: String, clazz: Class<*>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, T::class.java)
    } else {
        this.getSerializableExtra(key) as T?
    }
}