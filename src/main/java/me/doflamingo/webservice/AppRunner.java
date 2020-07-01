package me.doflamingo.webservice;

import me.doflamingo.webservice.board.Board;
import me.doflamingo.webservice.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
