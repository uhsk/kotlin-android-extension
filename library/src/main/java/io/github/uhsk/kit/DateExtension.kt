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
