package me.doflamingo.webservice.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    public void 글쓰기화면_보여주기() throws Exception {
        mockMvc.perform(get("/boards/write"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("writeBoard"));
    }

    @Test
    public void 게시판목록_보여주기() throws Exception {
        mockMvc.perform(get("/boards"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("boardList"));
    }

    @Test
    public void 게시판상세_보여주기() throws Exception {
        mockMvc.perform(get("/boards/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("boardDetail"));
    }

    @Test
    public void 게시판글쓰기() throws Exception {
        Board board = Board.builder().id(1L).title("제목").content("내용").author("나").created(LocalDate.now()).build();
        //given(boardService.addPost(any())).willReturn(board);
        mockMvc.perform(post("/boards/write")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"제목\",\"content\":\"내용\",\"author\":\"나\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("post added"));

        verify(boardService).addPost(any());
    }

}