package me.doflamingo.webservice.board;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
    }


    @Test
    public void 게시글_저장() {
        Board board =  Board.builder().title("게시글1").content("example1").author("me").created(LocalDate.now()).build();
        Board saved = boardRepository.save(board);

        assertThat(saved.getId()).isEqualTo(1L);

    }

    @Test
    public void 게시글리스트_불러오기() {
        boardRepository.save(Board.builder().title("1").content("1").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("2").content("2").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("3").content("3").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("4").content("4").author("me").created(LocalDate.now()).build());

        List<Board> boardList = boardRepository.findAll();

        assertThat(boardList.size()).isEqualTo(4);
    }



}