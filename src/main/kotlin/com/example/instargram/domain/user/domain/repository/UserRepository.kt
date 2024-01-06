package com.example.instargram.domain.user.domain.repository

import com.example.instargram.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, Long> {
    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean

    fun findByRe(accountId: String): User?
}
