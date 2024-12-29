package yoon.board_Practice2.post;

import org.springframework.stereotype.Service;
import yoon.board_Practice2.board.Board;
import yoon.board_Practice2.board.BoardRepository;
import yoon.board_Practice2.post.DTO.CreatePost;

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
}
