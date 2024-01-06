package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.presentation.dto.request.CreateMemoRequest
import com.example.instargram.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMomoService(
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(request: CreateMemoRequest) {
        val user = userFacade.getCurrentUser()
        user.updateMemo(request.memo)
    }
}