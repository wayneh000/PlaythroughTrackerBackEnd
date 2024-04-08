package io.github.wayneh000.playthroughtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.wayneh000.playthroughtracker.entity.Account;
import io.github.wayneh000.playthroughtracker.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccount(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Integer id, String username, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account validateAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
