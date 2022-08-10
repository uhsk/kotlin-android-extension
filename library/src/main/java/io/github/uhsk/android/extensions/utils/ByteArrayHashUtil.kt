package io.github.uhsk.android.extensions.utils

import org.apache.commons.codec.digest.DigestUtils

/**
 * @author sollyu
 * @date   2022-08-10
 */
class ByteArrayHashUtil(private val bytes: ByteArray) {

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun md2(): ByteArray = DigestUtils.md2(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun md5(): ByteArray = DigestUtils.md5(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha(): ByteArray = DigestUtils.sha1(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha1(): ByteArray = DigestUtils.sha1(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha256(): ByteArray = DigestUtils.sha256(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_224(): ByteArray = DigestUtils.sha3_224(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_256(): ByteArray = DigestUtils.sha3_256(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_384(): ByteArray = DigestUtils.sha3_384(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha3_512(): ByteArray = DigestUtils.sha3_512(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha384(): ByteArray = DigestUtils.sha384(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512(): ByteArray = DigestUtils.sha512(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512_224(): ByteArray = DigestUtils.sha512_224(bytes)

    /**
     * @since 1.0.0
     * @author sollyu
     */
    fun sha512_256(): ByteArray = DigestUtils.sha512_256(bytes)


}
