package io.github.uhsk.kit

import java.util.Date

/**
 * 时间戳转日期
 * @since 1.0.2
 * @author ethan
 */
fun Long.toDate(unix: Boolean = false): Date {
    return Date(if (unix) this * 1000 else this)
}
