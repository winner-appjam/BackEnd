package com.example.instargram.domain.study.domain

import com.example.instargram.domain.user.domain.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Study (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val content: String? = null,

    val fileUrl: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User? = null
)