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

import android.content.Context

/**
 * @since 1.0.3
 * @author sollyu
 */
context(Context)
fun Int.dp(): Int = this@Context.dp2px(dp = this)

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Int.dp(context: Context) = context.dp2px(dp = this)

/**
 * @since 1.0.3
 * @author sollyu
 */
context(Context)
fun Int.sp(): Int = this@Context.sp2px(sp = this)

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Int.sp(context: Context) = context.sp2px(sp = this)
