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

    public Board updatePost(Long id, Board post) {
        Board board = boardRepository.findById(id).orElse(null);
        board.setTitle(post.getTitle());
        board.setAuthor(post.getAuthor());
        board.setContent(post.getContent());
        board.setUpdated(board.getUpdated());
        return boardRepository.save(board);
    }
}
