package com.example.instargram.domain.study.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "tbl_study")
class Study (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val content: String? = null,

    val file: String? = null,

    val memo: String? = null,
)