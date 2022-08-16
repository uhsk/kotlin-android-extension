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

import org.apache.commons.io.FileUtils
import org.apache.commons.io.FilenameUtils

import java.io.File
import java.io.FileFilter

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.checksumCRC32
 */
fun File.crc32(): Long = FileUtils.checksumCRC32(this)

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
@Suppress(names = ["DEPRECATION"])
@Deprecated(message = "", replaceWith = ReplaceWith(expression = "sha1()"))
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

/**
 * @since 1.0.3
 * @author sollyu
 */
operator fun File.iterator(): Iterator<File> {
    return iterator(extensions = emptyArray(), recursive = false)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.iterateFiles
 */
fun File.iterator(extensions: Array<String>?, recursive: Boolean = false): Iterator<File> {
    return FileUtils.iterateFiles(this, extensions, recursive)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.contentEquals
 */
fun File.contentEquals(file: File): Boolean {
    return FileUtils.contentEquals(this, file)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.contentEquals
 */
val File.lengthToDisplaySize: String
    get() = FileUtils.byteCountToDisplaySize(this.length())

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.forceDelete
 */
fun File.forceDelete() {
    return FileUtils.forceDelete(this)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FileUtils.forceDeleteOnExit
 */
fun File.forceDeleteOnJvmExit() {
    return FileUtils.forceDeleteOnExit(this)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.normalize
 */
val File.pathNormalize: String
    get() = FilenameUtils.normalize(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.normalizeNoEndSeparator
 */
val File.nameNormalizeNoEndSeparator: String
    get() = FilenameUtils.normalizeNoEndSeparator(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.concat
 */
fun File.join(vararg paths: String): File {
    var basePath = this.path
    paths.forEach { basePath = FilenameUtils.concat(basePath, it) }
    return File(basePath)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.concat
 */
fun File.pathJoin(vararg paths: String): File = join(*paths)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.separatorsToUnix
 */
val File.pathSeparatorsToUnix: String
    get() = FilenameUtils.separatorsToUnix(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.separatorsToWindows
 */
val File.pathSeparatorsToWindows: String
    get() = FilenameUtils.separatorsToWindows(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.separatorsToSystem
 */
val File.pathSeparatorsToSystem: String
    get() = FilenameUtils.separatorsToSystem(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.getPathNoEndSeparator
 */
val File.pathNoEndSeparator: String
    get() = FilenameUtils.getPathNoEndSeparator(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.removeExtension
 */
val File.pathRemoveExtension: String
    get() = FilenameUtils.removeExtension(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.wildcardMatch
 */
fun File.pathWildcardMatch(wildcardMatcher: String): Boolean {
    return FilenameUtils.wildcardMatch(this.path, wildcardMatcher)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.getFullPath
 */
val File.pathDirectory: String
    get() = FilenameUtils.getFullPath(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.getFullPathNoEndSeparator
 */
val File.pathDirectoryNoEndSeparator: String
    get() = FilenameUtils.getFullPathNoEndSeparator(this.path)

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.isExtension
 */
fun File.isExtension(extension: String): Boolean {
    return FilenameUtils.isExtension(this.path, extension)
}

/**
 * @since 1.0.3
 * @author sollyu
 * @see FilenameUtils.isExtension
 */
fun File.isExtension(vararg extension: String): Boolean {
    return FilenameUtils.isExtension(this.path, extension)
}
