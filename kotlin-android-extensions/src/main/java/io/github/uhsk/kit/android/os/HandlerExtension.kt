package io.github.uhsk.kit.android.os

import android.os.Handler
import kotlinx.coroutines.Runnable
import java.util.concurrent.TimeUnit

fun Handler.postDelayed(delay: Long, unit: TimeUnit, runnable: Runnable) {
    this.postDelayed(runnable, unit.toMillis(delay))
}
