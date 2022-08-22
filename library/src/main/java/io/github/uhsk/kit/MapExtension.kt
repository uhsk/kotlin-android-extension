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
 * @since 1.0.3
 * @author sollyu
 */
inline fun <reified K, V> Map<out K, V>.getOrDefault(key: K, default: V): V? {
    if (this.containsKey(key).not())
        return default
    return this[key]
}


/**
 * 获取一个值，如果值不存在或者为null则返回默认值
 *
 * @since 1.0.3
 * @author sollyu
 */
inline fun <reified K, V> Map<out K, V>.getOrDefaultNotNull(key: K, default: V): V {
    return getOrDefault(key, default) ?: default
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
