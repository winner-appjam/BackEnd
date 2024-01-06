package com.example.instargram.domain.study.service

import com.example.instargram.domain.study.domain.Study
import com.example.instargram.domain.study.domain.repository.StudyRepository
import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.infrastructure.s3.S3Utils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class CreateFeedService(
    private val studyRepository: StudyRepository,
    private val userFacade: UserFacade,
    private val s3Utils: S3Utils
) {
    @Transactional
    fun execute(file: MultipartFile, content: String, title: String){
        val user = userFacade.getCurrentUser()
        val fileUrl = s3Utils.uploadImage(file)
        studyRepository.save(
            Study(
                user = user,
                title = title,
                content = content,
                fileUrl = fileUrl
            )
        )
        user.addRe()
    }
}