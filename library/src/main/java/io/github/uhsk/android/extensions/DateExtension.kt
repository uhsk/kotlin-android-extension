package io.github.uhsk.android.extensions

import io.github.uhsk.android.extensions.annotations.DateField
import java.text.SimpleDateFormat
import java.util.*

/**
 * @since 1.0.0
 * @author sollyu
 */
fun Date.format(pattern: String = "yyyy-MM-dd HH:mm:ss", locale: Locale = Locale.ENGLISH): String {
    return SimpleDateFormat(pattern, locale).format(this)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
operator fun Date.plus(amount: Int): Date {
    return this.plus(amount, field = Calendar.DAY_OF_MONTH)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
operator fun Date.minus(amount: Int): Date {
    return this.minus(amount, field = Calendar.DAY_OF_MONTH)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
fun Date.plus(amount: Int, @DateField field: Int): Date {
    val calendar = toCalendar()
    calendar.add(field, amount)
    return Date(calendar.timeInMillis)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
fun Date.minus(amount: Int, @DateField field: Int): Date {
    return this.plus(amount * -1, field)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
fun Date.toCalendar(): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.time
    return calendar
}
