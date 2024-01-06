package com.example.instargram.domain.user.service

import com.example.instargram.domain.study.presentation.dto.request.CreateFeedRequest
import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMomoService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun execute(request: CreateFeedRequest) {
        userRepository.save(
            User(
                memo = request.memo
            )
        )
    }
}