package com.example.instargram.domain.user.service

import com.example.instargram.domain.study.presentation.dto.request.CreateMemoRequest
import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMomoService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun execute(request: CreateMemoRequest) {
        userRepository.save(
            User(
                memo = request.memo
            )
        )
    }
}