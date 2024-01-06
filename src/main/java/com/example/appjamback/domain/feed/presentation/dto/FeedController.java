package com.example.appjamback.domain.feed.presentation.dto;

import com.example.appjamback.domain.feed.service.FeedUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedUploadService feedUploadService;

    @PostMapping
    public void upload(@RequestPart(required = false, name = "file")MultipartFile file, @RequestPart(required = false, name = "content")String content) {
        feedUploadService.execute(file,content);
    }
}
