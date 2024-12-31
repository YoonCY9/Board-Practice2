package yoon.board_Practice2.post;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yoon.board_Practice2.post.DTO.CreatePost;
import yoon.board_Practice2.post.DTO.PostUpdate;
import yoon.board_Practice2.post.DTO.PostResponse;

import java.util.List;

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

    @GetMapping("/posts")
    // 보드아이디에 상관없이 모든 포스트 조회
    public List<PostResponse> read() {
        return postService.allRead();
    }

    @GetMapping("/posts/{id}")
    // 포스트 id를 입력받아서 해당 포스트만 조회 and 조회수 증가
    public PostResponse findOne(@PathVariable Long id) {
        return postService.findOne(id);
    }

    @PutMapping("/posts/{id}")
    // json으로 받은 값만 수정함
    public void update(@PathVariable Long id, @Valid @RequestBody PostUpdate nameUpdate) {
        postService.update(id,nameUpdate);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
