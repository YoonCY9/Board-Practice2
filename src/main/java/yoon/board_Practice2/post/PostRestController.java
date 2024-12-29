package yoon.board_Practice2.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yoon.board_Practice2.board.DTO.CreateBoard;
import yoon.board_Practice2.post.DTO.CreatePost;

@RestController
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public void create(@Valid @RequestBody CreatePost post) {
        postService.create(post);
    }
}
