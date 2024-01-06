package com.example.appjamback.domain.feed.domain;

import com.example.appjamback.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "tbl_feed")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Feed {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String content;

    @ManyToOne
    private User user;
}
