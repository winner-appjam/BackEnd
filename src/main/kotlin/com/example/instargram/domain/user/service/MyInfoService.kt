package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.domain.user.presentation.dto.response.MyInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MyInfoService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): MyInfoResponse {
        val user = userFacade.getCurrentUser()
        return MyInfoResponse(
            name = user.name,
            school = user.school,
            fileUrl = user.file
        )
    }
}