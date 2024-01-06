package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.infrastructure.s3.S3Utils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class UserProfileUploadService(
    private val s3Utils: S3Utils,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(file: MultipartFile): String {
        val user = userFacade.getCurrentUser()
        return s3Utils.uploadImage(image = file)
    }
}