package me.doflamingo.webservice.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public ModelAndView showWriteBoard(@ModelAttribute Board board) {
        return new ModelAndView("writeBoard");
    }


    @GetMapping("/")
    public ModelAndView showBoardList() {
        return new ModelAndView("boardList");
    }

    @GetMapping("/{id}")
    public ModelAndView showBoardDetail(@PathVariable Long id) {
        return new ModelAndView("boardDetail");
    }


    @PostMapping("/write")
    @ResponseBody public String addPost(@RequestBody Board board) {
        boardService.addPost(board);
        return "post added";
    }

}
