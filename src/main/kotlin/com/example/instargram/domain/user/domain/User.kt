package com.example.instargram.domain.user.domain

import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountId: String? = null,

    val name: String? = null,

    val password: String? = null,

    var memo: String? = null,

    var year: Int? = null,

    var month: Int? = null,

    var day: Int? = null,

    var re: Int ? = null

    ) {
    fun updateMemo(memo: String?) {
        this.memo = memo
    }

    fun modify(accountId: String,name: String,password: String,year: Int, month: Int, day: Int) {
        this.accountId
        this.name
        this.password
        this.year = year
        this.month = month
        this.day = day
    }

    fun addRe() {
        this.re = (this.re ?: 0) + 5
    }
}
