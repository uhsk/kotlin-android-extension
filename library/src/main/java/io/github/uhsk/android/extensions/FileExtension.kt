package io.github.uhsk.android.extensions

import org.apache.commons.io.FileUtils

import java.io.File
import java.io.FileFilter

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.md2(): ByteArray = this.inputStream().md2()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.md5(): ByteArray = this.inputStream().md5()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha(): ByteArray = this.inputStream().sha()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha1(): ByteArray = this.inputStream().sha1()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha256(): ByteArray = this.inputStream().sha256()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha3_224(): ByteArray = this.inputStream().sha3_224()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha3_256(): ByteArray = this.inputStream().sha3_256()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha3_384(): ByteArray = this.inputStream().sha3_384()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha3_512(): ByteArray = this.inputStream().sha3_512()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha384(): ByteArray = this.inputStream().sha384()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha512(): ByteArray = this.inputStream().sha512()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha512_224(): ByteArray = this.inputStream().sha512_224()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.sha512_256(): ByteArray = this.inputStream().sha512_256()

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.moveTo(dest: File) = FileUtils.moveFile(this, dest)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.moveToDirectory(dest: File, createDestDir: Boolean = false) = FileUtils.moveFileToDirectory(this, dest, createDestDir)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.asDirectoryClear() = FileUtils.cleanDirectory(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.asDirectoryDelete() = FileUtils.deleteDirectory(this)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.asDirectoryCopyTo(destDir: File, filter: FileFilter? = null, preserveFileDate: Boolean = true) = FileUtils.copyDirectory(this, destDir, filter, preserveFileDate)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.asDirectoryMoveTo(destDir: File) = FileUtils.moveDirectory(this, destDir)

/**
 * @since 1.0.0
 * @author sollyu
 */
fun File.asDirectoryMoveToDirectory(destDir: File, createDestDir: Boolean = false) = FileUtils.moveDirectoryToDirectory(this, destDir, createDestDir)
