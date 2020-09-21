package me.doflamingo.webservice.board;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("local")
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeAll
    public void setUp() {
        testEntityManager.persist(Board.builder().id(1L).title("1").content("1").author("me").created(LocalDate.now()).build());
        testEntityManager.persist(Board.builder().id(2L).title("2").content("2").author("me").created(LocalDate.now()).build());
        testEntityManager.persist(Board.builder().id(3L).title("3").content("3").author("me").created(LocalDate.now()).build());
        testEntityManager.persist(Board.builder().id(4L).title("4").content("4").author("me").created(LocalDate.now()).build());
        System.out.println("Test Start");
//        boardRepository.save(Board.builder().title("1").content("1").author("me").created(LocalDate.now()).build());
//        boardRepository.save(Board.builder().title("2").content("2").author("me").created(LocalDate.now()).build());
//        boardRepository.save(Board.builder().title("3").content("3").author("me").created(LocalDate.now()).build());
//        boardRepository.save(Board.builder().title("4").content("4").author("me").created(LocalDate.now()).build());
    }

    @AfterEach
    public void cleanUp() {
        boardRepository.deleteAll();
        System.out.println("test finish");
    }


    @Test
    public void 게시글_저장() {
        Board board =  Board.builder().title("게시글1").content("example1").author("me").created(LocalDate.now()).build();
        Board saved = boardRepository.save(board);

        assertThat(saved.getId()).isEqualTo(13L);

    }

    @Test
    public void 게시글리스트_불러오기() {
        List<Board> boardList = boardRepository.findAll();
        System.out.println(boardList.size());
        assertThat(boardList.size()).isEqualTo(4);
    }


    @Test
    public void 게시글_불러오기() {
        Optional<Board> byId = boardRepository.findById(1L);
        assertThat(byId).isNotEmpty();
        assertThat(byId.get().getId()).isEqualTo(1L);
    }



}