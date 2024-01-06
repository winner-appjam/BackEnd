package com.example.instargram.domain.study.domain.repository

import com.example.instargram.domain.study.domain.Study
import com.example.instargram.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface StudyRepository: JpaRepository<Study, Long> {

    fun findAllByUser(user: User): Study
}