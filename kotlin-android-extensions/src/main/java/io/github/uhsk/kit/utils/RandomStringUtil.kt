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

package io.github.uhsk.kit.utils

import org.apache.commons.lang3.RandomStringUtils
import kotlin.random.Random

/**
 * @author sollyu
 * @date   2022-08-10
 */
class RandomStringUtil(private val random: Random) {

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomAscii
     */
    fun ascii(count: Int): String = RandomStringUtils.randomAscii(count)

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomAlphabetic
     */
    fun alphabetic(count: Int): String = RandomStringUtils.randomAlphabetic(count)

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomAlphanumeric
     */
    fun alphanumeric(count: Int): String = RandomStringUtils.randomAlphanumeric(count)

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomGraph
     */
    fun graph(count: Int): String = RandomStringUtils.randomGraph(count)

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomNumeric
     */
    fun numeric(count: Int): String = RandomStringUtils.randomNumeric(count)

    /**
     * @since 1.0.2
     * @author sollyu
     * @see RandomStringUtils.randomPrint
     */
    fun print(count: Int): String = RandomStringUtils.randomPrint(count)

}
