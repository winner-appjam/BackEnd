package com.example.instargram.infrastructure.s3

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AwsConfig {
    @Value("\${spring.cloud.aws.credentials.accessKey}")
    private val accessKey: String? = null

    @Value("\${spring.cloud.aws.credentials.secretKey}")
    private val secretKey: String? = null

    @Value("\${spring.cloud.aws.region.static}")
    private val region: String? = null
    @Bean
    fun amazonS3(): AmazonS3 {
        val awsCredentials: AWSCredentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonS3ClientBuilder.standard()
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .build()
    }
}