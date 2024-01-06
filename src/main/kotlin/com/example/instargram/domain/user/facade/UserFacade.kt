package com.example.instargram.domain.user.facade

import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.domain.repository.UserRepository
import com.example.instargram.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User? {
        val accountId = SecurityContextHolder.getContext().authentication.name
        SecurityContextHolder.clearContext()
        return getUserByInfo(accountId)
    }

    fun getUserByInfo(info: String): User? =
        userRepository.findByInfo(info)
}
