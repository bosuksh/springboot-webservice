package me.doflamingo.webservice.board;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardService {

    BoardRepository boardRepository;

    public Board addPost(Board board) {
        return boardRepository.save(board);
    }
}
