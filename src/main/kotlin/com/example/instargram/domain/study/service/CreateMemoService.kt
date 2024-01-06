package com.example.instargram.domain.study.service

import com.example.instargram.domain.study.domain.Study
import com.example.instargram.domain.study.domain.repository.StudyRepository
import com.example.instargram.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMemoService(
    private val studyRepository: StudyRepository,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: com.example.instargram.domain.user.presentation.dto.request.CreateMemoRequest) {
        val user = userFacade.getCurrentUser()
        studyRepository.save(
            Study(
                memo = request.memo,
                user = user
            )
        )
    }
}