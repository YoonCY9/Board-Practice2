package yoon.board_Practice2.board;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yoon.board_Practice2.board.DTO.BoardResponse;
import yoon.board_Practice2.board.DTO.CreateBoard;

import java.util.List;

@RestController
public class BoardRestController {

    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public void create(@Valid @RequestBody CreateBoard board) {
        boardService.create(board);
    }

    @GetMapping("/boards")
    public List<BoardResponse> allRead(@Valid @RequestBody BoardResponse board) {
        return boardService.allRead();
    }

    @DeleteMapping("/boards/{id}")
    public void delete(@PathVariable Long id) {
        boardService.deleteById(id);
    }
}
