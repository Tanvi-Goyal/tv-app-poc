package com.embibe.app.embibetvapp.awsUtils

import android.util.Log
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.embibe.app.embibetvapp.activity.App
import java.io.IOException
import java.util.*

object AWSAccessProvider {

    private val CLASS_TAG = AWSAccessProvider::class.java.name
    private const val KEY_ACCESS_KEY = "accessKey"
    private const val KEY_SECRET_KEY = "secretKey"

    val s3ClientForPreSignUrl: AmazonS3?
        get() {
            try {
                val resources = App.context.resources
                val assetManager = resources.assets
                val inputStream = assetManager.open("aws.properties")
                val properties = Properties()
                properties.load(inputStream)
                val accessKey =
                    AESCrypto.getInstance()?.decrypt(properties.getProperty(KEY_ACCESS_KEY))
                val secretKey =
                    AESCrypto.getInstance()?.decrypt(properties.getProperty(KEY_SECRET_KEY))
                val creds = BasicAWSCredentials(accessKey!!, secretKey!!)
                return AmazonS3Client(creds)
            } catch (e: Throwable) {
                Log.e(CLASS_TAG, "Failed to open aws property file")
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

    fun getS3Client(): AmazonS3? {
        try {
            val resources = App.context.resources
            val assetManager = resources.assets
            val inputStream = assetManager.open("aws.properties")
            val properties = Properties()
            properties.load(inputStream)
            val accessKey = AESCrypto.getInstance()?.decrypt(properties.getProperty(KEY_ACCESS_KEY))
            val secretKey = AESCrypto.getInstance()?.decrypt(properties.getProperty(KEY_SECRET_KEY))
            val creds = BasicAWSCredentials(accessKey!!, secretKey!!)
            return AmazonS3Client(creds)
        } catch (e: IOException) {
            Log.e(CLASS_TAG, "Failed to open aws property file")
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}
