package yoon.board_Practice2.comments;

import org.springframework.web.bind.annotation.*;
import yoon.board_Practice2.comments.DTO.CommentResponse;
import yoon.board_Practice2.comments.DTO.CreateComment;

import java.util.List;

@RestController
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public void create(@RequestBody CreateComment comment) {
        commentService.create(comment);
    }

    @GetMapping("/comments/{id}")
    //     포스트아이디에 해당하는 댓글 조회
    public List<CommentResponse> postCommentsRead(@PathVariable Long id) {
        return commentService.postCommentRead(id);
    }

    @PutMapping("/comments/{id}")
    // id를 패스배리어블로 받고 받아서 json으로 들어온 값만 덮어씌우는 로직
    public void update(@PathVariable Long id, @RequestBody CommentResponse response) {
        commentService.commentUpdate(id, response);
    }


    @DeleteMapping("/comments/{id}")
    // 해당 아이디값의 댓글 삭제
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
