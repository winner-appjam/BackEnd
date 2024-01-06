package com.example.instargram.domain.study.service

import com.example.instargram.domain.study.domain.Study
import com.example.instargram.domain.study.domain.repository.StudyRepository
import com.example.instargram.domain.study.presentation.dto.request.CreateMemoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMemoService(
    private val studyRepository: StudyRepository
) {
    @Transactional
    fun execute(request: CreateMemoRequest) {
        studyRepository.save(
            Study(
                memo = request.memo
            )
        )
    }
}