package com.modelmapper.modelmapper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String text;
    @ManyToOne
    @JoinColumn(name="post_Id")
    private Post post;
}
