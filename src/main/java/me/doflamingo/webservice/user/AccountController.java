package me.doflamingo.webservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{userId}")
    public HttpEntity<?> getAccount(@PathVariable String userId) {
        Account account = accountService.getAccount(userId);
        return ResponseEntity.ok().body(account);
    }

}
