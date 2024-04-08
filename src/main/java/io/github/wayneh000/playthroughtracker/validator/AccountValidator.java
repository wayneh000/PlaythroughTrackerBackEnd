package io.github.wayneh000.playthroughtracker.validator;

public class AccountValidator {

	public static void validateUsername(String username) {
		if (username == null || username.isBlank())
			throw new IllegalArgumentException("Username cannot be blank.");
	}
	
	public static void validatePassword(String password) {
		if (password == null || password.isBlank())
			throw new IllegalArgumentException("Password cannot be blank.");
	}
}
