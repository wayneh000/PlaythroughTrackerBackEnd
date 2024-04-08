package io.github.wayneh000.playthroughtracker.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import io.github.wayneh000.playthroughtracker.validator.AccountValidator;

@Aspect
@Component
public class AccountAspect {

	@Before("execution(* io.github.wayneh000.playthroughtracker.service.AccountService.createAccount(..)) && " +
			"args(username,password)")
	public void createAccountBeforeAdvice(String username, String password) {
		AccountValidator.validateUsername(username);
		AccountValidator.validatePassword(password);
	}
}
