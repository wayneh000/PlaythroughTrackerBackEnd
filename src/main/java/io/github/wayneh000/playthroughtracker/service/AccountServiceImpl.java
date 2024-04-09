package io.github.wayneh000.playthroughtracker.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import io.github.wayneh000.playthroughtracker.entity.Account;
import io.github.wayneh000.playthroughtracker.exception.InvalidCredentialsException;
import io.github.wayneh000.playthroughtracker.exception.PlaythroughTrackerException;
import io.github.wayneh000.playthroughtracker.exception.UserAlreadyExistsException;
import io.github.wayneh000.playthroughtracker.exception.UserNotFoundException;
import io.github.wayneh000.playthroughtracker.repository.AccountRepository;
import io.github.wayneh000.playthroughtracker.util.PasswordUtils;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	private PasswordUtils passwordUtils;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		this.passwordUtils = PasswordUtils.getInstance();
	}

	@Override
	public Account createAccount(String username, String password) throws PlaythroughTrackerException {
		Account account = findAccountByUsername(username);
		if (account != null)
			throw new UserAlreadyExistsException();
		account = new Account();
		account.setUsername(username);
		account.setPassword(passwordUtils.hashPassword(password));
		account.setDateCreated(LocalDateTime.now());
		return accountRepository.save(account);
	}

	@Override
	public Account findAccount(Integer id) throws PlaythroughTrackerException {
		return accountRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public Account updateAccount(Integer id, String username, String oldPassword, String newPassword) throws PlaythroughTrackerException {
		Account account = findAccount(id);
		if (!passwordUtils.validatePassword(oldPassword, account.getPassword()))
			throw new InvalidCredentialsException();
		Account duplicateAccount = accountRepository.findByUsername(username).orElse(null);
		if (duplicateAccount != null && duplicateAccount.getUsername().equals(account.getUsername()) && !duplicateAccount.getId().equals(account.getId()))
			throw new UserAlreadyExistsException();
		account.setUsername(username);
		account.setPassword(passwordUtils.hashPassword(newPassword));
		return accountRepository.save(account);
	}

	@Override
	public Account validateAccount(String username, String password) throws PlaythroughTrackerException {
		Account account = findAccountByUsername(username);
		if (account == null)
			throw new InvalidCredentialsException();
		if (!passwordUtils.validatePassword(password, account.getPassword()))
			throw new InvalidCredentialsException();
		return account;
	}
	
	private Account findAccountByUsername(String username) {
		return accountRepository.findByUsername(username).orElse(null);
	}
}
