package io.github.wayneh000.playthroughtracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wayneh000.playthroughtracker.entity.Account;
import io.github.wayneh000.playthroughtracker.exception.PlaythroughTrackerException;
import io.github.wayneh000.playthroughtracker.request.AccountRequest;
import io.github.wayneh000.playthroughtracker.request.UpdateAccountRequest;
import io.github.wayneh000.playthroughtracker.service.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody AccountRequest request) throws PlaythroughTrackerException {
		return new ResponseEntity<>(accountService.createAccount(request.getUsername(), request.getPassword()), HttpStatus.CREATED);
	}
	
	@GetMapping("/findAccount/{id}")
	public ResponseEntity<Account> findAccount(@PathVariable Integer id) throws PlaythroughTrackerException {
		return new ResponseEntity<>(accountService.findAccount(id), HttpStatus.OK);
	}
	
	@PutMapping("/updateAccount")
	public ResponseEntity<Account> updateAccount(@RequestBody UpdateAccountRequest request) throws PlaythroughTrackerException {
		return new ResponseEntity<>(accountService.updateAccount(request.getId(), request.getUsername(), request.getOldPassword(), request.getNewPassword()), HttpStatus.OK);
	}
	
	@GetMapping("/validateAccount")
	public ResponseEntity<Account> validateAccount(@RequestBody AccountRequest request) throws PlaythroughTrackerException {
		return new ResponseEntity<>(accountService.validateAccount(request.getUsername(), request.getPassword()), HttpStatus.OK);
	}
}
