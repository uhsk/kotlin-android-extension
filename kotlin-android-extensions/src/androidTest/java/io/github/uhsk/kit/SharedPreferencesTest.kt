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
import android.content.SharedPreferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@Suppress(names = ["DEPRECATION"])
@RunWith(AndroidJUnit4::class)
class SharedPreferencesTest {

    @Test
    fun has() {
        val keyName: String = "__test_has_key__"
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val sharedPreferences: SharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(appContext)
        sharedPreferences.edit().remove(keyName).commit()

        Assert.assertEquals(false, sharedPreferences.has(keyName))
        sharedPreferences.edit().putString(keyName, "kotlin").commit()
        Assert.assertEquals(true, sharedPreferences.has(keyName))
    }

    @Test
    fun getJson() {
        val keyName: String = "__test_get_json_key__"
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val sharedPreferences: SharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(appContext)
        sharedPreferences.edit().remove(keyName).commit()

        val defaultJsonObject = JSONObject()
        defaultJsonObject.put("name", "kotlin")

        Assert.assertEquals("", sharedPreferences.getJson(keyName, default = null), null)
        Assert.assertEquals("", sharedPreferences.getJson(keyName, default = defaultJsonObject)?.toString(), defaultJsonObject.toString())
    }

    @Test
    fun putJson() {
        val keyName: String = "__test_put_json_key__"
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val sharedPreferences: SharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(appContext)
        sharedPreferences.edit().remove(keyName).commit()

        val defaultJsonObject = JSONObject()
        defaultJsonObject.put("name", "kotlin")
        sharedPreferences.edit().putJson(keyName, defaultJsonObject).commit()
        Assert.assertEquals("""{"name":"kotlin"}""", sharedPreferences.getString(keyName, null))
    }
}
