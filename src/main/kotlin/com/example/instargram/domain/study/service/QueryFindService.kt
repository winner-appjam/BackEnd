package com.example.instargram.domain.study.service

import com.example.instargram.domain.study.domain.repository.StudyRepository
import com.example.instargram.domain.study.presentation.dto.response.QueryFindResponse
import com.example.instargram.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFindService(
    private val studyRepository: StudyRepository,
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(studyId: Long): QueryFindResponse { val study = studyRepository.findById(studyId)
        .orElseThrow { NoSuchElementException("Study not found with ID") }

        return QueryFindResponse(
            title = study.title.toString(),
            content = study.content.toString(),
            accountId = study.user!!.accountId.toString()
        )
        }
}
