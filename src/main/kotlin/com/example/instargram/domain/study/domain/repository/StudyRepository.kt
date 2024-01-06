package com.example.instargram.domain.study.domain.repository

import com.example.instargram.domain.study.domain.Study
import org.springframework.data.jpa.repository.JpaRepository

interface StudyRepository: JpaRepository<Study, Long> {
}