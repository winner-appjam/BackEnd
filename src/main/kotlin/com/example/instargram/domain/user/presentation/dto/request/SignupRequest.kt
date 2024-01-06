package com.example.instargram.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class SignupRequest (

    @NotBlank(message = "info은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    val info: String,

    @Pattern(
        regexp =
        "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
        message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다."
    )
    val password: String,

    @NotBlank(message = "accountId은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    val accountId: String,

    val name: String,

    @NotNull
    val year: Int,

    @NotNull
    val month: Int,

    @NotNull
    val day: Int
)
