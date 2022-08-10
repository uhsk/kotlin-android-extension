package io.github.uhsk.android.extensions

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.StringRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Suppress(names = ["FunctionName"])
private fun Intent.__contextStartActivityDefaultFlag(block: (Intent.() -> Unit)?) {
    if (block == null) {
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        this.block()
    }
}

@MainThread
fun Context.startActivityForPackageNameByDefaultIntent(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent: Intent = this.packageManager.getLaunchIntentForPackage(packageName) ?: throw NullPointerException()
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

@MainThread
fun Context.startActivityForSystemSettingsByApplicationDetails(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    intent.data = Uri.parse("package:$packageName")
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

@MainThread
fun Context.startActivityForSystemSettingsByAccessibility(block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

@MainThread
fun Context.startActivityForLauncherHome(block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_MAIN)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

@MainThread
fun Context.startActivityForUrlByDefaultBrowser(url: String, block: (Intent.() -> Unit)? = null) {
    startActivityForUrlByDefaultBrowser(Uri.parse(url), block)
}

@MainThread
fun Context.startActivityForUrlByDefaultBrowser(uri: Uri, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

@MainThread
fun Context.showDialogForUninstallApplication(packageName: String, block: (Intent.() -> Unit)? = null) {
    val intent = Intent(Intent.ACTION_DELETE, Uri.fromParts("package", packageName, null))
    intent.__contextStartActivityDefaultFlag(block)
    this.startActivity(intent)
}

fun Context.getSystemServiceForClipboardManager(): ClipboardManager {
    return this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
}

@MainThread
fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}

@MainThread
fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, resId, duration).show()
}

suspend fun Context.showToastBySuspend(text: CharSequence, duration: Int = Toast.LENGTH_LONG) = withContext(context = Dispatchers.Main) {
    showToast(text, duration)
}

suspend fun Context.showToastBySuspend(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) = withContext(context = Dispatchers.Main) {
    showToast(resId, duration)
}
