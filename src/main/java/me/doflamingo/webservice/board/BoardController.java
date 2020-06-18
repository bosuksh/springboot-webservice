package me.doflamingo.webservice.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @GetMapping("/board/write")
    public ModelAndView showWriteBoard(@ModelAttribute Board board) {
        return new ModelAndView("writeBoard");
    }
}
