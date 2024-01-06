package com.example.instargram.domain.user.domain

import com.example.instargram.domain.user.enums.ProfileType
import com.example.instargram.domain.user.enums.Sex
import com.example.instargram.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity(name = "tbl_user")
class User(
    id: UUID? = null,

    @Column(name = "account_id", nullable = false, unique = true, columnDefinition = "VARCHAR(60)")
    val accountId: String,

    @Column(name = "email", nullable = true, unique = true, columnDefinition = "VARCHAR(60)")
    val info: String,

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(30)")
    val name: String,

    @Column(name = "self_introduce", nullable = true, columnDefinition = "VARCHAR(60)")
    val selfIntroduce: String? = null,

    @Column(name = "profile_link", nullable = true, )
    val profileLink: String? = null,

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(60)")
    val password: String,

    @Column(name = "profile_recommend", nullable = false, columnDefinition = "VARCHAR(100)")
    val recommend: Boolean? = null,

    @Column(name = "year", nullable = false, columnDefinition = "Integer(255)")
    val year: Int,

    @Column(name = "month", nullable = false, columnDefinition = "Integer(12)")
    val month: Int,

    @Column(name = "day", nullable = false, columnDefinition = "Integer(31)")
    val day: Int,

    @Column(name = "sex", nullable = false)
    @Enumerated(EnumType.STRING)
    val sex: Sex? = null,

    @Column(name = "profile_type", nullable = false)
    @Enumerated(EnumType.STRING)
    val profileType: ProfileType? = null

): BaseUUIDEntity(id) {
}
