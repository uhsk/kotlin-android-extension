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

package io.github.uhsk.kit.annotations

import androidx.annotation.IntDef
import java.util.*

@IntDef(
    value = [
        Calendar.ERA,
        Calendar.YEAR,
        Calendar.MONTH,
        Calendar.WEEK_OF_YEAR,
        Calendar.WEEK_OF_MONTH,
        Calendar.DAY_OF_MONTH,
        Calendar.DAY_OF_YEAR,
        Calendar.DAY_OF_WEEK,
        Calendar.DAY_OF_WEEK_IN_MONTH,
        Calendar.AM_PM,
        Calendar.HOUR,
        Calendar.HOUR_OF_DAY,
        Calendar.MINUTE,
        Calendar.SECOND,
        Calendar.MILLISECOND,
        Calendar.ZONE_OFFSET,
        Calendar.DST_OFFSET,
        Calendar.FIELD_COUNT,
    ]
)
@Retention(value = AnnotationRetention.SOURCE)
annotation class DateField
