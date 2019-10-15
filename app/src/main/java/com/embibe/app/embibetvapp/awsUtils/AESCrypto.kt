package com.embibe.app.embibetvapp.awsUtils

import android.annotation.SuppressLint
import android.util.Base64
import java.security.Key
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Created by prashant on 16/2/17.
 */

class AESCrypto @Throws(NoSuchAlgorithmException::class)
private constructor() {

    init {
        val sha = MessageDigest.getInstance("SHA-1")
        var keyValue = sha.digest(KEY_VALUE.toByteArray())
        keyValue = keyValue.copyOf(32)
        secrateKey = SecretKeySpec(keyValue, ALGO)
    }

    @SuppressLint("GetInstance")
    @Throws(Exception::class)
    fun encrypt(data: String?): String? {
        if (data != null) {
            val c = Cipher.getInstance(ALGO)
            c.init(Cipher.ENCRYPT_MODE, secrateKey)
            val encryptedValue = c.doFinal(data.toByteArray())
            return Base64.encodeToString(encryptedValue, Base64.DEFAULT)
        }
        return null
    }

    @SuppressLint("GetInstance")
    @Throws(Exception::class)
    fun decrypt(data: String?): String? {
        if (data != null) {
            val c = Cipher.getInstance(ALGO)
            c.init(Cipher.DECRYPT_MODE, secrateKey)
            val decodedValue = Base64.decode(data, Base64.DEFAULT)
            val devValue = c.doFinal(decodedValue)
            return String(devValue)
        }
        return null
    }

    companion object {

        const val ALGO = "AES"
        const val KEY_VALUE = "28F8A10F2CD4802CE3DDBF6CF0327DDF3DDAA84100939A9635921C789063968E"

        lateinit var secrateKey: Key

        private var instance: AESCrypto? = null

        fun getInstance(): AESCrypto? {
            if (instance == null) {
                synchronized(AESCrypto::class.java) {
                    if (instance == null) {
                        try {
                            instance = AESCrypto()
                        } catch (e: NoSuchAlgorithmException) {
                            e.printStackTrace()
                        }

                    }
                }
            }
            return instance
        }
    }
}
