package me.doflamingo.webservice.board;

import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public ModelAndView showWriteBoard(@ModelAttribute Board board) {

        ModelAndView view = new ModelAndView("writeBoard");
        view.addObject("contentNum",-1);
        return view;
    }


    @GetMapping()
    public ModelAndView showBoardList() {
        List<Board> boardList = boardService.retrievePostList();
        ModelAndView modelAndView = new ModelAndView("boardList");
        modelAndView.addObject("postList",boardList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showBoardDetail(@PathVariable Long id) {
        Board board = boardService.retrievePost(id);
        ModelAndView view = new ModelAndView("writeBoard");
        view.addObject("contentNum",id);
        view.addObject("post",board);
        return view;
    }


    @PostMapping("/write")
    public @ResponseBody Board addPost(@RequestBody Board board) {
        logger.error(board.toString());
        Board newPost = boardService.addPost(board);
        return newPost;
    }

    @PutMapping("/write/{id}")
    public @ResponseBody Board updatePost(@PathVariable Long id,@RequestBody Board board) {
        logger.info(board.toString());
        Board newPost = boardService.updatePost(id,board);
        return newPost;
    }


}
