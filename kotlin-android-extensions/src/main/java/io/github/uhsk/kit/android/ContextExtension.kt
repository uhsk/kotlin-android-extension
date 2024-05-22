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

import android.Manifest
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes
import io.github.uhsk.kit.android.defs.AudioServiceStreamFlags
import io.github.uhsk.kit.android.defs.AudioServiceStreamType
import java.io.File

@Suppress(names = ["FunctionName"])
private fun Intent.__contextStartActivityDefaultFlag(block: (Intent.() -> Unit)?) {
    if (block == null) {
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        this.block()
    }
}

/**
 * 设置屏幕密度
 *
 * @see [Context#attachBaseContext]
 * @since 1.0.12
 * @author sollyu
 */
@Suppress(names = ["DEPRECATION"])
fun Context.updateDensityDpi(density: Int = DisplayMetrics.DENSITY_DEFAULT) {
    val resources: Resources = this.resources
    val configuration: Configuration = resources.configuration
    val displayMetrics: DisplayMetrics = resources.displayMetrics
    displayMetrics.densityDpi = density
    configuration.densityDpi = density
    resources.updateConfiguration(configuration, displayMetrics)
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
 * 跳转到手机设置的Wi-Fi页面
 *
 * @since 1.0.11
 * @author sollyu
 */
@MainThread
fun Context.startActivityForSystemSettingsByWirelessSettings(block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 跳转到手机关机页面
 *
 * @since 1.0.11
 * @author sollyu
 */
@MainThread
@RequiresPermission(value = "com.android.internal.intent.action.REQUEST_SHUTDOWN")
fun Context.startActivityForSystemByShutdown(block: (Intent.() -> Unit)? = null) {
    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN")
    } else {
        Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN")
    }
    intent.putExtra("android.intent.extra.KEY_CONFIRM", false)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 跳转到拨号页面
 *
 * @since 1.0.11
 * @author sollyu
 */
@MainThread
fun Context.startActivityForSystemByPhoneNumber(value: String, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(value)))
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 跳转到发送短信
 *
 * @since 1.0.11
 * @author sollyu
 */
@MainThread
fun Context.startActivityForSystemBySms(number: String, content: CharSequence, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + Uri.encode(number)))
    intent.putExtra("sms_body", content)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 返回到桌面
 *
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
 * 使用默认浏览器打开网址
 *
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForUrlByDefaultBrowser(url: String, block: (Intent.() -> Unit)? = null) {
    startActivityForUrlByDefaultBrowser(Uri.parse(url), block)
}

/**
 * 使用默认浏览器打开网址
 *
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
 * 打开分享文本的界面
 *
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
fun Context.startActivityForShareText(value: String, title: String = "", block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, value)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(Intent.createChooser(intent, title))
}

fun Context.startActivityForShareImage(block: (Intent.() -> Unit)? = null) {
    TODO("Not yet implemented")
}

fun Context.startActivityForShareFile(block: (Intent.() -> Unit)? = null) {
    TODO("Not yet implemented")
}

/**
 * 跳转到安装app页面
 *
 * @since 1.0.13
 * @author sollyu
 */
@RequiresPermission(value = Manifest.permission.REQUEST_INSTALL_PACKAGES)
fun Context.startActivityForInstallPackage(uri: Uri, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.setDataAndType(uri, "application/vnd.android.package-archive")
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

/**
 * 显示卸载app对话框
 *
 * 需要 [android.permission.REQUEST_DELETE_PACKAGES] 权限
 *
 * @since 1.0.1
 * @author sollyu
 */
@MainThread
@RequiresApi(Build.VERSION_CODES.O)
@RequiresPermission(value = Manifest.permission.REQUEST_DELETE_PACKAGES)
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
 * @since 1.0.11
 * @author sollyu
 */
fun Context.getSystemServiceForAudioService(): AudioManager {
    return this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
}

/**
 * @since 1.0.11
 * @author sollyu
 */
fun Context.getSystemServiceForConnectivityManager(): ConnectivityManager {
    return this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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
 * @since 1.0.11
 * @author sollyu
 */
fun Context.isLandscape(): Boolean {
    return this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

/**
 * @since 1.0.11
 * @author sollyu
 */
fun Context.isPortrait(): Boolean {
    return this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
}

/**
 * 获取当前音量大小
 *
 * @since 1.0.11
 * @author sollyu
 */
fun Context.getVolume(@AudioServiceStreamType type: Int = AudioManager.STREAM_MUSIC): Int {
    return this.getSystemServiceForAudioService().getStreamVolume(type)
}

/**
 * 获取最大支持的音量
 *
 * @since 1.0.11
 * @author sollyu
 */
fun Context.getMaxVolume(@AudioServiceStreamType type: Int = AudioManager.STREAM_MUSIC) {
    this.getSystemServiceForAudioService().getStreamMaxVolume(type)
}

/**
 * 获取最小支持的音量
 *
 * @since 1.0.11
 * @author sollyu
 */
@RequiresApi(Build.VERSION_CODES.P)
fun Context.getMinVolume(@AudioServiceStreamType type: Int = AudioManager.STREAM_MUSIC) {
    this.getSystemServiceForAudioService().getStreamMinVolume(type)
}

/**
 * 获取设置音量
 *
 * @since 1.0.11
 * @author sollyu
 * @see getMinVolume
 * @see getMaxVolume
 */
fun Context.setVolume(value: Int, @AudioServiceStreamType type: Int = AudioManager.STREAM_MUSIC, @AudioServiceStreamFlags flags: Int = AudioManager.FLAG_SHOW_UI) {
    this.getSystemServiceForAudioService().setStreamVolume(type, value, flags)
}

/**
 * @since 1.0.11
 * @author sollyu
 * @sample /storage/emulated/0/Android/data/package/files/Download
 */
fun Context.getPathOfExternalDownload(): File? {
    return this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
}

/**
 * @since 1.0.11
 * @author sollyu
 * @sample /storage/emulated/0/Android/data/package/files/Download
 */
fun Context.getPathOfExternalDcim(): File? {
    return this.getExternalFilesDir(Environment.DIRECTORY_DCIM)
}

/**
 * @since 1.0.11
 * @author sollyu
 * @sample /storage/emulated/0/Android/data/package/files/Movies
 */
fun Context.getPathOfExternalMovies(): File? {
    return this.getExternalFilesDir(Environment.DIRECTORY_MOVIES)
}

/**
 * @since 1.0.11
 * @author sollyu
 * @sample /storage/emulated/0/Android/data/package/files/Pictures
 */
fun Context.getPathOfExternalPictures(): File? {
    return this.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
}

/**
 * @since 1.0.11
 * @author sollyu
 * @sample /storage/emulated/0/Android/obb/package
 */
fun Context.getPathOfObb(): File {
    return this.obbDir
}

/**
 * 当前屏幕的DPI
 *
 * @since 1.0.3
 * @author sollyu
 */
val Context.density: Float
    get() = this.resources.displayMetrics.density

/**
 * 当前字体的DPI
 *
 * @since 1.0.3
 * @author sollyu
 */
val Context.fontDensity: Float
    get() = this.resources.displayMetrics.scaledDensity
