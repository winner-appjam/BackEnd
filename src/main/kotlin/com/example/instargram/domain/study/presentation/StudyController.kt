package com.example.instargram.domain.study.presentation

import com.example.instargram.domain.study.presentation.dto.response.QueryFindResponse
import com.example.instargram.domain.study.service.CreateFeedService
import com.example.instargram.domain.study.service.QueryAllFeedService
import com.example.instargram.domain.study.service.QueryFindService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/study")
class StudyController(
    private val createFeedService: CreateFeedService,
    private val queryFindService: QueryFindService,
    private val queryAllFeedService: QueryAllFeedService
) {
    @PostMapping
    fun createFeed(@RequestPart(name = "file", required = false)file: MultipartFile, @RequestPart content: String, @RequestPart title: String) =
        createFeedService.execute(file, content, title)

    @GetMapping("/{study_id}")
    fun findQuery(@PathVariable(name = "study_id") studyId: Long): QueryFindResponse =
        queryFindService.execute(studyId)

    @GetMapping
    fun findAll() =
        queryAllFeedService.execute()

}