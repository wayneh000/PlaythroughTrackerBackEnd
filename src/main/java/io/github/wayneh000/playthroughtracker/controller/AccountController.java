package io.github.wayneh000.playthroughtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody AccountRequest request) throws PlaythroughTrackerException {
		return accountService.createAccount(request.getUsername(), request.getPassword());
	}
	
	@GetMapping("/findAccount/{id}")
	public Account findAccount(@PathVariable Integer id) throws PlaythroughTrackerException {
		return accountService.findAccount(id);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestBody UpdateAccountRequest request) throws PlaythroughTrackerException {
		return accountService.updateAccount(request.getId(), request.getUsername(), request.getOldPassword(), request.getNewPassword());
	}
	
	@GetMapping("/validateAccount")
	public Account validateAccount(@RequestBody AccountRequest request) throws PlaythroughTrackerException {
		return accountService.validateAccount(request.getUsername(), request.getPassword());
	}
}
