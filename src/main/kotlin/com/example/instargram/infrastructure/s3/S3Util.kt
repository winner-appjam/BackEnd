package com.example.instargram.infrastructure.s3

import com.amazonaws.HttpMethod
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
class S3Utils(
    private val amazonS3: AmazonS3
) {
    @Value("\${spring.cloud.aws.s3.bucket}")
    lateinit var bucketName: String

    companion object {
        const val EXP_TIME = 1000 * 60 * 2
        const val PATH: String = "appjam/"
    }

    fun uploadImage(image: MultipartFile): String {

        val fileName = "${UUID.randomUUID()}${image.originalFilename}"

        try {
            val request = PutObjectRequest(
                bucketName, fileName, image.inputStream, getObjectMetadata(image)
            ).withCannedAcl(CannedAccessControlList.PublicRead)

            amazonS3.putObject(request)
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }

        return generateObjectUrl(fileName)
    }

    private fun getObjectMetadata(image: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = image.size
        objectMetadata.contentType = image.contentType

        return objectMetadata
    }

    fun generateObjectUrl(fileName: String): String {
        val expiration = Date().apply {
            time += EXP_TIME
        }

        return amazonS3.generatePresignedUrl(
            GeneratePresignedUrlRequest(
                bucketName,
                "${PATH}$fileName"
            ).withMethod(HttpMethod.GET).withExpiration(expiration)
        ).toString()
    }
}