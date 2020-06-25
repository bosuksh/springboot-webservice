package me.doflamingo.webservice.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    private BoardService boardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        boardService = new BoardService(boardRepository);
    }

    @Test
    public void 게시글올리기() {
        Board board = Board.builder().author("나").title("제목").content("content").created(LocalDate.now()).build();
        given(boardRepository.save(board)).willReturn(board);
        Board added = boardService.addPost(board);
        assertThat(added.getAuthor()).isEqualTo("나");
    }

    @Test
    public void 게시글리스트보여주기() {
        List<Board> mockBoardList = new ArrayList<>();
        mockBoardList.add(Board.builder().title("제목").content("내용").build());
        mockBoardList.add(Board.builder().title("제목2").content("내용2").build());

        given(boardRepository.findAll()).willReturn(mockBoardList);

        List<Board> boardList = boardService.retrievePostList();

        assertThat(boardList.size()).isEqualTo(2);
        assertThat(boardList.get(0).getContent()).isEqualTo("내용");
    }

    @Test
    public void 게시글보여주기() {
        //Board mockBoard = Board.builder().title("제목").content("내용").author("나").build();
        boardService.retrievePost(1L);
        verify(boardRepository).findById(any());
    }

}