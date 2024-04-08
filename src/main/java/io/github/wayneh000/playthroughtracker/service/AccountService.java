package io.github.wayneh000.playthroughtracker.service;

import org.springframework.stereotype.Service;

import io.github.wayneh000.playthroughtracker.entity.Account;

@Service
public interface AccountService {

	Account createAccount(String username, String password);
	Account findAccount(Integer id);
	Account updateAccount(Integer id, String username, String oldPassword, String newPassword);
	Account validateAccount(String username, String password);
}
