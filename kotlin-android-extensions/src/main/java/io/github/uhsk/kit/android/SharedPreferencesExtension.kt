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

package io.github.uhsk.kit.android

import android.content.SharedPreferences
import androidx.core.content.edit
import org.json.JSONObject

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.has(key: String): Boolean = this.all.containsKey(key)

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.getJson(key: String, default: JSONObject? = null): JSONObject? {
    if (has(key).not()) {
        return default
    }
    val string: String = getString(key, null) ?: return default
    return JSONObject(string)
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.Editor.putJson(key: String, value: JSONObject): SharedPreferences.Editor {
    this.putString(key, value.toString())
    return this
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getStringOrNull(key: String): String? {
    return if (has(key)) {
        getString(key, null)
    } else {
        null
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.putStringOrRemove(key: String, value: String?) {
    if (value == null) {
        edit { remove(key) }
    } else {
        edit { putString(key, value) }
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getIntOrNull(key: String): Int? {
    return if (has(key)) {
        getInt(key, 0)
    } else {
        null
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.putIntOrRemove(key: String, value: Int?) {
    if (value == null) {
        edit { remove(key) }
    } else {
        edit { putInt(key, value) }
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getLongOrNull(key: String): Long? {
    return if (has(key)) {
        getLong(key, 0L)
    } else {
        null
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.putLongOrRemove(key: String, value: Long?) {
    if (value == null) {
        edit { remove(key) }
    } else {
        edit { putLong(key, value) }
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getFloatOrNull(key: String): Float? {
    return if (has(key)) {
        getFloat(key, 0f)
    } else {
        null
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.putFloatOrRemove(key: String, value: Float?) {
    if (value == null) {
        edit { remove(key) }
    } else {
        edit { putFloat(key, value) }
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getBooleanOrNull(key: String): Boolean? {
    return if (has(key)) {
        getBoolean(key, false)
    } else {
        null
    }
}

/**
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.putBooleanOrRemove(key: String, value: Boolean?) {
    if (value == null) {
        edit { remove(key) }
    } else {
        edit { putBoolean(key, value) }
    }
}

