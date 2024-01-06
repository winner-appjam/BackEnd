package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.domain.user.presentation.dto.response.QueryMemoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MyMemoQueryService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): QueryMemoResponse {
        val user = userFacade.getCurrentUser()
        return QueryMemoResponse(
            memo = user.memo.toString()
        )
    }
}