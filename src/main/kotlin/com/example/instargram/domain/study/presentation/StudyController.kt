package com.example.instargram.domain.study.presentation

import com.example.instargram.domain.study.service.CreateFeedService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/study")
class StudyController(
    private val createFeedService: CreateFeedService
) {
    @PostMapping
    fun createFeed(@RequestPart(name = "file", required = false)file: MultipartFile, @RequestPart content: String, @RequestPart title: String) =
        createFeedService.execute(file, content, title)
}