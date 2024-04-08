package io.github.wayneh000.playthroughtracker.service;

import org.springframework.stereotype.Service;

import io.github.wayneh000.playthroughtracker.entity.Account;
import io.github.wayneh000.playthroughtracker.exception.PlaythroughTrackerException;

@Service
public interface AccountService {

	Account createAccount(String username, String password) throws PlaythroughTrackerException;
	Account findAccount(Integer id) throws PlaythroughTrackerException;
	Account updateAccount(Integer id, String username, String oldPassword, String newPassword) throws PlaythroughTrackerException;
	Account validateAccount(String username, String password) throws PlaythroughTrackerException;
}
