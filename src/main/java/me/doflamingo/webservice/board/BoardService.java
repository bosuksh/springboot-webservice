package me.doflamingo.webservice.board;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    BoardRepository boardRepository;

    public Board addPost(Board board) {
        return boardRepository.save(board);
    }


    public List<Board> retrievePostList() {
        return boardRepository.findAll();
    }

    public Board retrievePost(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}
