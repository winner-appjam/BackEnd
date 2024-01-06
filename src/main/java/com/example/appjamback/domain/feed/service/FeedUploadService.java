package com.example.appjamback.domain.feed.service;

import com.example.appjamback.domain.feed.domain.Feed;
import com.example.appjamback.domain.feed.domain.repository.FeedRepository;
import com.example.appjamback.domain.user.domain.User;
import com.example.appjamback.domain.user.facade.UserFacade;
import com.example.appjamback.infra.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FeedUploadService {
    private final FeedRepository feedRepository;
    private final S3Util s3Util;
    private final UserFacade userFacade;

    @Transactional
    public void execute(MultipartFile file, String content) {
        User user = userFacade.getCurrentUser();
        String url = s3Util.uploadImage(file);
        feedRepository.save(
                Feed.builder()
                        .user(user)
                        .content(content)
                        .imageUrl(url)
                        .build()
        );
    }
}
