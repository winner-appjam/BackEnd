package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.exception.PasswordMissMatchException
import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.domain.user.presentation.dto.request.ModifyRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ModifyInfoService(
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: ModifyRequest) {
        val user = userFacade.getCurrentUser()
        if(request.newPassword != request.validPassword) throw PasswordMissMatchException
        user.modify(request.accountId, request.newPassword, request.name, request.year, request.month, request.day)
    }
}