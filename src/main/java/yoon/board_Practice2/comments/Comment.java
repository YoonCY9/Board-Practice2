package yoon.board_Practice2.comments;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import yoon.board_Practice2.post.Post;

import java.util.List;

@Entity

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(String name, String content, Post post) {
        this.name = name;
        this.content = content;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
