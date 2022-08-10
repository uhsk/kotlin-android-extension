package io.github.uhsk.android.extensions.utils

import org.apache.commons.io.output.ByteArrayOutputStream
import java.io.ByteArrayInputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * @author sollyu
 * @date   2022-08-10
 */
class ByteArrayGzipUtil(private val bytes: ByteArray) {

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun compress(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val gzipOutputStream = GZIPOutputStream(byteArrayOutputStream)
        gzipOutputStream.write(bytes)
        gzipOutputStream.close()
        return byteArrayOutputStream.toByteArray()
    }

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun uncompress(buffSize: Int = 256): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val byteArrayInputStream = ByteArrayInputStream(bytes)
        val gzipInputStream = GZIPInputStream(byteArrayInputStream)
        val buffer = ByteArray(buffSize)
        var n: Int
        while (gzipInputStream.read(buffer).also { n = it } >= 0) {
            byteArrayOutputStream.write(buffer, 0, n)
        }
        return byteArrayOutputStream.toByteArray()
    }

}
