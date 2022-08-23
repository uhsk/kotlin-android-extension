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

import io.github.uhsk.kit.annotations.DateField
import org.apache.commons.lang3.time.DateUtils
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
 * @since 1.0.3
 * @author sollyu
 */
fun Date.add(amount: Int, @DateField field: Int = Calendar.DAY_OF_MONTH): Date {
    return plus(amount, field)
}

/**
 * @since 1.0.0
 * @author sollyu
 */
fun Date.toCalendar(): Calendar {
    return DateUtils.toCalendar(this)
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Date.toCalendar(timeZone: TimeZone): Calendar {
    return DateUtils.toCalendar(this, timeZone)
}

/**
 * @since 1.0.2
 * @author sollyu
 */
fun Date.toSqlTime(): java.sql.Time {
    return java.sql.Time(this.time)
}

/**
 * @since 1.0.2
 * @author sollyu
 */
fun Date.toSqlDate(): java.sql.Date {
    return java.sql.Date(this.time)
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Date.toSqlTimestamp(): java.sql.Timestamp {
    return java.sql.Timestamp(this.time)
}

/**
 * @since 1.0.3
 * @author sollyu
 */
val Date.timestamp: Long
    get() = this.time

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Date.isToday(): Boolean = android.text.format.DateUtils.isToday(this.time)

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Date.isSameDay(time: Long) = DateUtils.isSameDay(this, time.toDate())

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Date.isSameDay(date: Date) = DateUtils.isSameDay(this, date)
