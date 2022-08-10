package io.github.uhsk.android.extensions.annotations

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
