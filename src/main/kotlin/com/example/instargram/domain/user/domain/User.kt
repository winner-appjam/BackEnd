package com.example.instargram.domain.user.domain

import com.example.instargram.domain.study.domain.Study
import javax.persistence.*

@Entity(name = "tbl_user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "account_id", nullable = false, unique = true, columnDefinition = "VARCHAR(60)")
    val accountId: String? = null,
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(30)")
    val name: String? = null,

    val password: String? = null,

    val memo: String? = null

)
