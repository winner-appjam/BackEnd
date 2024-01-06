package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.domain.repository.UserRepository
import com.example.instargram.domain.user.exception.PasswordMissMatchException
import com.example.instargram.domain.user.exception.UserAlreadyException
import com.example.instargram.domain.user.presentation.dto.request.SignupRequest
import com.example.instargram.global.security.jwt.JwtTokenProvider
import com.example.instargram.global.security.jwt.dto.TokenResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserSignupService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    @Transactional
    fun execute(request: SignupRequest): TokenResponse {
        if (userRepository.existsByAccountId(request.accountId)) {
            throw UserAlreadyException
        }
        if (request.validPassword != request.password) {
            throw PasswordMissMatchException
        }
        val password = passwordEncoder.encode(request.password)
        userRepository.save(
            User(
                accountId = request.accountId,
                password = password,
                name = request.name
            )
        )
        return jwtTokenProvider.getToken(request.accountId)
    }
}
