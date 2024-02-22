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

package io.github.uhsk.kit.android

import android.database.Cursor
import androidx.core.database.getBlobOrNull
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getFloatOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getLongOrNull
import androidx.core.database.getShortOrNull
import androidx.core.database.getStringOrNull

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getIndexOrNull(column: String?): Int? {
    if (column == null) {
        return null
    }
    val index: Int = getColumnIndex(column)
    if (index == -1) {
        return null
    }
    return index
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getStringByColumnOrNull(column: String?): String? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getStringOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getBlobByColumnOrNull(column: String?): ByteArray? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getBlobOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getDoubleByColumnOrNull(column: String?): Double? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getDoubleOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getFloatByColumnOrNull(column: String?):Float? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getFloatOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getIntByColumnOrNull(column: String?): Int? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getIntOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getLongByColumnOrNull(column: String?): Long? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getLongOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getShortByColumnOrNull(column: String?): Short? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getShortOrNull(index)
}

/**
 * @since 1.0.12
 * @author sollyu
 */
fun Cursor.getBooleanByColumnOrNull(column: String?): Boolean? {
    val index: Int = getIndexOrNull(column) ?: return null
    return getIntOrNull(index) == 1
}


