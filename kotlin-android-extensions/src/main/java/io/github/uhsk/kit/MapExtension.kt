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

/**
 * 或者一个值：值的内容允许为[null]
 *
 * @since 1.0.6
 * @author sollyu
 */
inline fun <reified K, V> Map<out K, V>.getValueIfNotExist(key: K, default: V): V? {
    if (this.containsKey(key).not())
        return default
    return this[key]
}


/**
 * 获取一个值，如果值不存在或者为null则返回默认值
 *
 * @since 1.0.6
 * @author sollyu
 */
inline fun <reified K, V> Map<out K, V>.getValueIfNull(key: K, default: V): V {
    return getValueIfNotExist(key, default) ?: default
}

/**
 * 获取一个值(字符串限定)，如果值的内容为空（包括null）返回默认值
 *
 * @since 1.0.7
 * @author sollyu
 */
inline fun <reified K, V : CharSequence?> Map<out K, V>.getValueIfNullOrEmpty(key: K, default: V): V {
    val value = getValueIfNull(key, default)
    return if (value == null || value.isEmpty()) default else value
}

/**
 * 获取一个值(字符串限定)，如果值的内容为空（包括null）返回默认值
 *
 * @since 1.0.7
 * @author sollyu
 */
inline fun <reified K, V : CharSequence?> Map<out K, V>.getValueIfNullOrBlank(key: K, default: V): V {
    val value = getValueIfNull(key, default)
    return if (value == null || value.isBlank()) default else value
}

/**
 * 获取一个值，如果值的内容满足条件就返回默认值
 * 1. 如果[key]不存在将直接返回[default]
 * 2. 如果[value]值为[null]将直接返回[default]
 *
 * @since 1.0.7
 * @author sollyu
 */
inline fun <reified K, V> Map<out K, V>.getValueIfNullOrPredicate(key: K, default: V, predicate: (value: V) -> Boolean): V {
    if (this.containsKey(key).not()) {
        return default
    }
    val value = this[key] ?: return default
    if (predicate(value)) {
        return default
    }
    return value
}

/**
 * 获取一个值并强转成指定类型
 *
 * @since 1.0.3
 * @author sollyu
 */
@Suppress(names = ["UNCHECKED_CAST"])
inline fun <reified K, V> Map<out K, *>.getValueAs(key: K): V {
    return this[key] as V
}
