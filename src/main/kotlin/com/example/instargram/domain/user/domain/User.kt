package com.example.instargram.domain.user.domain

import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountId: String? = null,

    val name: String? = null,

    val password: String? = null,

    var memo: String? = null

) {
    fun updateMemo(memo: String?) {
        this.memo = memo
    }
}
