package com.example.instargram.domain.study.presentation

import com.example.instargram.domain.study.presentation.dto.request.CreateMemoRequest
import com.example.instargram.domain.study.service.CreateMemoService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/study")
class StudyController(
    private val createMemoService: CreateMemoService
) {
    @PostMapping("/memo")
    fun createMemo(@RequestBody createMemoRequest: CreateMemoRequest) =
        createMemoService.execute(createMemoRequest)


}