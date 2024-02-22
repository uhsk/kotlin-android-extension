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

package io.github.uhsk.android.extension.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.uhsk.android.extension.app.databinding.ActivityMainBinding
import io.github.uhsk.kit.android.startActivityForSystemByShutdown

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        mViewBinding.btnContextTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mViewBinding.btnContextTest -> onClickButtonTest(v)
        }
    }

    private fun onClickButtonTest(view: View) {
        this.startActivityForSystemByShutdown()
    }
}
