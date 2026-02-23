package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id=0;
    @Column(length=100,nullable =false)
    private  String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private  String content;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    public Post(String title, String content){
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
        this.title = title;
        this.content = content;
    }
}
