package com.embibe.app.embibetvapp.awsUtils

import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.embibe.app.embibetvapp.model.S3BucketandPath
import java.net.URL

object S3Utils {
     fun getPreSignedURL(bucketName: String, objectName: String): URL? {
        // Set the pre-signed URL to expire after three hour.
        val expiration = java.util.Date()
        var expTimeMillis = expiration.time
        expTimeMillis += (24000 * 60 * 60).toLong()
        expiration.time = expTimeMillis
        val request = GeneratePresignedUrlRequest(bucketName, objectName).withExpiration(expiration)
        return AWSAccessProvider.getS3Client()?.generatePresignedUrl(request)
    }

    fun getS3Model(url: String): S3BucketandPath {
        val s3BucketPath = S3BucketandPath()
        s3BucketPath.bucketPath = getBucketName(url)
        val s3Paths =
            url.split((s3BucketPath.bucketPath + "/").toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
        s3BucketPath.filePath = s3Paths[1]
        return s3BucketPath
    }


    private fun getBucketName(url: String?): String {
        var fileName = ""
        if (url != null) {
            var index = url.indexOf(".com/")
            if (index != -1) {
                fileName = url.substring(index + 1)
                index = fileName.indexOf("/")
                fileName = fileName.substring(index + 1)
            }
            val indexPath = fileName.indexOf("/")
            if (indexPath != -1) {
                fileName = fileName.substring(0, indexPath)
            }
        }
        return fileName
    }

}