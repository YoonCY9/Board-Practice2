package yoon.board_Practice2.comments;

import org.springframework.stereotype.Service;
import yoon.board_Practice2.comments.DTO.CommentResponse;
import yoon.board_Practice2.comments.DTO.CreateComment;
import yoon.board_Practice2.post.Post;
import yoon.board_Practice2.post.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void create(CreateComment dto) {
        // 댓글 생성 (이름,내용,포스트아이디)
        Post post = postRepository.findById(dto.postId()).orElseThrow();
        Comment comment = new Comment(dto.name(), dto.content(), post);
        commentRepository.save(comment);
    }

    public List<CommentResponse> postCommentRead(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        return comments.stream().map(c -> new CommentResponse(c.getName(), c.getContent(), post.getId())).toList();
    }

    public void commentUpdate(Long id, CommentResponse dto) {
        // id를 패스배리어블로 받고 받아서 json으로 들어온 값만 덮어씌우는 로직
        Comment comment = commentRepository.findById(id).orElseThrow();
        if (dto.name() != null) {
            comment.setName(dto.name());
        }
        if (dto.content() != null) {
            comment.setContent(dto.content());
        }
        commentRepository.save(comment);
    }

    public void delete(Long id) {
        // 해당 아이디값의 댓글 삭제
        commentRepository.deleteById(id);
    }
}
