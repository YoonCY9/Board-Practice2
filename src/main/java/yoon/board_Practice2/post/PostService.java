package yoon.board_Practice2.post;

import org.springframework.stereotype.Service;
import yoon.board_Practice2.board.Board;
import yoon.board_Practice2.board.BoardRepository;
import yoon.board_Practice2.post.DTO.CreatePost;
import yoon.board_Practice2.post.DTO.PostUpdate;
import yoon.board_Practice2.post.DTO.PostResponse;

import java.util.*;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostService(PostRepository postRepository,BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    public void create(CreatePost dto) {
        Board board = boardRepository.findById(dto.boardId()).orElseThrow();
        Post post = new Post(dto.name(), dto.title(), dto.content(),board);
        postRepository.save(post);
    }

    public List<PostResponse> allRead() {
        // 보드아이디에 상관없이 모든 포스트 조회
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(p -> new PostResponse
                (p.getName(), p.getTitle(), p.getContent(), p.getViewCount())).toList();
    }

    public PostResponse findOne(Long id) {
        // 포스트아이디로 해당 포스트만 조회 and 조회수 증가
        Post post = postRepository.findById(id).orElseThrow();
        post.viewCountIncrease(post.getViewCount());
        postRepository.save(post);
        return new PostResponse(post.getName(), post.getTitle(), post.getContent(), post.getViewCount());
    }

    public void update(Long id, PostUpdate dto) {
        // 포스트 내용 수정 json값에 들어온것만 바꿈
        Post post = postRepository.findById(id).orElseThrow();
        if (dto.name() != null) {
            post.setName(dto.name());
        }
        if (dto.title() != null) {
            post.setTitle(dto.title());
        }
        if (dto.content() != null) {
            post.setContent(dto.content());
        }
        postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

}
