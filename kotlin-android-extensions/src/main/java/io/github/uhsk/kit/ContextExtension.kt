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

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.StringRes

@Suppress(names = ["FunctionName"])
private fun Intent.__contextStartActivityDefaultFlag(block: (Intent.() -> Unit)?) {
    if (block == null) {
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        this.block()
    }
}

/**
 * 根据包名打开一个程序
 *
 * @param packageName 软件包名
 * @param block [Intent]自定义回调
 *
 * @since 1.0.1
 * @author sollyu
 * @throws NullPointerException 获取intent失败时
 */
@MainThread
@Throws(exceptionClasses = [NullPointerException::class])
fun Context.startActivityForPackageNameByDefaultIntent(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent: Intent = this.packageManager.getLaunchIntentForPackage(packageName) ?: throw NullPointerException()
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 跳转到已安装app的详细页面
 *
 * @param packageName 软件包名
 * @param block [Intent]自定义回调
 *
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForSystemSettingsByApplicationDetails(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    intent.data = Uri.parse("package:$packageName")
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 跳转到手机设置的无障碍页面
 *
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForSystemSettingsByAccessibility(block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForLauncherHome(block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_MAIN)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForUrlByDefaultBrowser(url: String, block: (Intent.() -> Unit)? = null) {
    startActivityForUrlByDefaultBrowser(Uri.parse(url), block)
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForUrlByDefaultBrowser(uri: Uri, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.showDialogForUninstallApplication(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_DELETE, Uri.fromParts("package", packageName, null))
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * @since 1.0.1
 * @author sollyu
 */
fun Context.getSystemServiceForClipboardManager(): ClipboardManager {
    return this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}

/**
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, resId, duration).show()
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Context.dp2px(dp: Int): Int {
    return (density * dp + 0.5).toInt()
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Context.sp2px(sp: Int): Int {
    return (fontDensity * sp + 0.5).toInt()
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Context.px2dp(px: Int): Int {
    return (px / density + 0.5).toInt()
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun Context.px2sp(px: Int): Int {
    return (px / fontDensity + 0.5).toInt()
}

/**
 * @since 1.0.3
 * @author sollyu
 */
val Context.density: Float
    get() = this.resources.displayMetrics.density

/**
 * @since 1.0.3
 * @author sollyu
 */
val Context.fontDensity: Float
    get() = this.resources.displayMetrics.scaledDensity
