package me.doflamingo.webservice.user;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public Account getAccount(String userId) {
        return new Account();
    }
}
