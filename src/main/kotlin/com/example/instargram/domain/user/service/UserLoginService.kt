package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.exception.PasswordMissMatchException
import com.example.instargram.domain.user.exception.UserNotFoundException
import com.example.instargram.domain.user.facade.UserFacade
import com.example.instargram.domain.user.presentation.dto.request.LoginRequest
import com.example.instargram.global.security.jwt.JwtTokenProvider
import com.example.instargram.global.security.jwt.dto.TokenResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserLoginService(
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userFacade: UserFacade,
) {

    @Transactional(readOnly = true)
    fun execute(request: LoginRequest): TokenResponse {
        val user = userFacade.getUserByInfo(request.info)?: throw UserNotFoundException
        if (!passwordEncoder.matches(request.password, user.password)) throw PasswordMissMatchException
        return jwtTokenProvider.getToken(user.info)
    }
}
