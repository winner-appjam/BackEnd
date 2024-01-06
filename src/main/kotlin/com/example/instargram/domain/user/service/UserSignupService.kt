package com.example.instargram.domain.user.service

import com.example.instargram.domain.user.domain.User
import com.example.instargram.domain.user.domain.repository.UserRepository
import com.example.instargram.domain.user.exception.EmailCodeMissMatchException
import com.example.instargram.domain.user.exception.SmsCodeMissMatchException
import com.example.instargram.domain.user.presentation.dto.request.SignupRequest
import com.example.instargram.infrastructure.mail.domain.repository.MailRepository
import com.example.instargram.infrastructure.mail.service.MailSendService
import com.example.instargram.infrastructure.sms.domain.repository.SmsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserSignupService(
    private val userRepository: UserRepository,
    private val mailRepository: MailRepository,
    private val smsRepository: SmsRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun execute(request: SignupRequest) {

        val info = request.info
        if (info.contains("@")) {
            val validEmailCode = mailRepository.findByIdOrNull(request.info)?: throw EmailCodeMissMatchException

            val user = User(
                info = info,
                password = passwordEncoder.encode(request.password),
                accountId = request.accountId,
                name = request.name,
                year = request.year,
                month = request.month,
                day = request.day
            )
            userRepository.save(user)
        }

        else if (info.length == 11) {
            val validSmsCode = smsRepository.findByIdOrNull(request.info)?: throw SmsCodeMissMatchException

            val user = User(
                info = request.info,
                password = passwordEncoder.encode(request.password),
                accountId = request.accountId,
                name = request.name,
                year = request.year,
                month = request.month,
                day = request.day
            )
            userRepository.save(user)
        }

    }
}
