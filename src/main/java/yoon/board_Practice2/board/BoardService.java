package yoon.board_Practice2.board;

import org.springframework.stereotype.Service;
import yoon.board_Practice2.board.DTO.BoardResponse;
import yoon.board_Practice2.board.DTO.CreateBoard;
import yoon.board_Practice2.board.DTO.UpdateBoard;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(CreateBoard dto) {
        Board board = new Board(dto.title());
        boardRepository.save(board);
    }

    public List<BoardResponse> allRead() {
        List<Board> alls = boardRepository.findAll();
        return alls.stream().map(b -> new BoardResponse(b.getTitle(), b.getId())).toList();
    }

    public void update(Long id, UpdateBoard dto) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.setTitle(dto.title());
        boardRepository.save(board);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}
