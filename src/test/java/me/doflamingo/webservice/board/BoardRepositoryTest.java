package me.doflamingo.webservice.board;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Profile("test")
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void setUp() {
        boardRepository.save(Board.builder().title("1").content("1").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("2").content("2").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("3").content("3").author("me").created(LocalDate.now()).build());
        boardRepository.save(Board.builder().title("4").content("4").author("me").created(LocalDate.now()).build());
    }

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
    }


    @Test
    public void 게시글_저장() {
        Board board =  Board.builder().title("게시글1").content("example1").author("me").created(LocalDate.now()).build();
        Board saved = boardRepository.save(board);

        assertThat(saved.getId()).isEqualTo(5L);

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


    @Test
    public void 게시글_불러오기() {
        Optional<Board> byId = boardRepository.findById(1L);
        assertThat(byId).isNotEmpty();
        assertThat(byId.get().getId()).isEqualTo(1L);
    }



}