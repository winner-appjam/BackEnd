package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.domain.user.presentation.dto.request.AddSchoolRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateSchoolService (
    private val userFacade: UserFacade
){
    @Transactional
    fun execute(request: AddSchoolRequest) {
        val user = userFacade.getCurrentUser()
        user.addSchool(request.school)
    }
}