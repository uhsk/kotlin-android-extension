package io.github.uhsk.kit.android.os

import android.os.Looper

/**
 * 检查当前Looper是否为主线程Looper的属性扩展
 *
 * 该属性可以安全地处理null值，如果接收者为null，将返回false
 */
val Looper?.isMain: Boolean
    get() = this.isMainLooper()

/**
 * 检查当前Looper是否为主线程Looper
 *
 * 该方法可以安全地处理null值，如果接收者为null，将返回false
 *
 * @return 如果当前Looper是主线程Looper则返回true，否则返回false
 */
fun Looper?.isMainLooper(): Boolean {
    if (this == null) {
        return false
    }
    return this == Looper.getMainLooper()
}

