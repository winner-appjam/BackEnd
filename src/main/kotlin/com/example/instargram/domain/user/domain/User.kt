package com.example.instargram.domain.user.domain

import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var accountId: String? = null,

    var name: String? = null,

    var password: String? = null,

    var memo: String? = null,

    var year: Int? = null,

    var month: Int? = null,

    var day: Int? = null,

    var re: Int ? = null,

    var school: String?= null,

    var file: String? = null

    ) {
    fun updateMemo(memo: String?) {
        this.memo = memo
    }

    fun modify(accountId: String,name: String,password: String,year: Int, month: Int, day: Int) {
        this.accountId = accountId
        this.name = name
        this.password = password
        this.year = year
        this.month = month
        this.day = day
    }

    fun addRe() {
        this.re = (this.re ?: 0) + 5
    }
    fun addSchool(school: String) {
        this.school = school
    }

    fun upload(file: String) {
        this.file = file
    }
}
