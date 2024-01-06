package com.example.instargram.domain.study.service

import com.example.instargram.domain.study.domain.repository.StudyRepository
import com.example.instargram.domain.study.presentation.dto.response.QueryAllFeedResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryAllFeedService(
    private val studyRepository: StudyRepository,
) {
   @Transactional(readOnly = true)
   fun execute(): List<QueryAllFeedResponse> {
       return studyRepository.findAll().map {it->
           QueryAllFeedResponse(
               title = it.content.toString(),
               user = it.user!!.name
           )
       }
   }
}