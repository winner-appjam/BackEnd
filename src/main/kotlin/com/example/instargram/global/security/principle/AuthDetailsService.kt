package com.example.instargram.global.security.principle

import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {
    override fun loadUserByUsername(accountId : String?) : UserDetails {
        val user: User? = accountId?.let { userFacade.getUserByAccountId(it) }
        return AuthDetails(user!!.accountId)
    }
}
