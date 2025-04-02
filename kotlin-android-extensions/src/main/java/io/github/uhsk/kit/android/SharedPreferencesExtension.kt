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
 * 检查SharedPreferences中是否存在指定的key
 * @param key 要检查的键名
 * @return 如果存在返回true，否则返回false
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.has(key: String): Boolean = this.all.containsKey(key)

/**
 * 获取JSON对象
 * @param key 键名
 * @param default 默认值，如果不存在或解析失败则返回此值
 * @return JSON对象，如果不存在或解析失败则返回默认值
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
 * 保存JSON对象
 * @param key 键名
 * @param value 要保存的JSON对象
 * @return Editor对象，支持链式调用
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.Editor.putJson(key: String, value: JSONObject): SharedPreferences.Editor {
    this.putString(key, value.toString())
    return this
}

/**
 * 获取字符串值，如果不存在则返回null
 * @param key 键名
 * @return 字符串值，如果不存在则返回null
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
 * 获取字符串值，如果不存在则返回默认值
 * @param key 键名
 * @param defaultValue 默认值
 * @return 字符串值，如果不存在则返回默认值
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getStringOrDefault(key: String, defaultValue: String): String {
    return if (has(key)) {
        getString(key, defaultValue) ?: defaultValue
    } else {
        defaultValue
    }
}

/**
 * 保存字符串值，如果值为null则删除该键
 * @param key 键名
 * @param value 要保存的值，如果为null则删除该键
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
 * 获取整数值，如果不存在则返回null
 * @param key 键名
 * @return 整数值，如果不存在则返回null
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
 * 获取整数值，如果不存在则返回默认值
 * @param key 键名
 * @param defaultValue 默认值
 * @return 整数值，如果不存在则返回默认值
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getIntOrDefault(key: String, defaultValue: Int): Int {
    return if (has(key)) {
        getInt(key, defaultValue)
    } else {
        defaultValue
    }
}

/**
 * 保存整数值，如果值为null则删除该键
 * @param key 键名
 * @param value 要保存的值，如果为null则删除该键
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
 * 获取长整数值，如果不存在则返回null
 * @param key 键名
 * @return 长整数值，如果不存在则返回null
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
 * 获取长整数值，如果不存在则返回默认值
 * @param key 键名
 * @param defaultValue 默认值
 * @return 长整数值，如果不存在则返回默认值
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getLongOrDefault(key: String, defaultValue: Long): Long {
    return if (has(key)) {
        getLong(key, defaultValue)
    } else {
        defaultValue
    }
}

/**
 * 保存长整数值，如果值为null则删除该键
 * @param key 键名
 * @param value 要保存的值，如果为null则删除该键
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
 * 获取浮点数值，如果不存在则返回null
 * @param key 键名
 * @return 浮点数值，如果不存在则返回null
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
 * 获取浮点数值，如果不存在则返回默认值
 * @param key 键名
 * @param defaultValue 默认值
 * @return 浮点数值，如果不存在则返回默认值
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getFloatOrDefault(key: String, defaultValue: Float): Float {
    return if (has(key)) {
        getFloat(key, defaultValue)
    } else {
        defaultValue
    }
}

/**
 * 保存浮点数值，如果值为null则删除该键
 * @param key 键名
 * @param value 要保存的值，如果为null则删除该键
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
 * 获取布尔值，如果不存在则返回null
 * @param key 键名
 * @return 布尔值，如果不存在则返回null
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
 * 获取布尔值，如果不存在则返回默认值
 * @param key 键名
 * @param defaultValue 默认值
 * @return 布尔值，如果不存在则返回默认值
 * @since 1.0.14
 * @author sollyu
 */
fun SharedPreferences.getBooleanOrDefault(key: String, defaultValue: Boolean): Boolean {
    return if (has(key)) {
        getBoolean(key, defaultValue)
    } else {
        defaultValue
    }
}

/**
 * 保存布尔值，如果值为null则删除该键
 * @param key 键名
 * @param value 要保存的值，如果为null则删除该键
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

