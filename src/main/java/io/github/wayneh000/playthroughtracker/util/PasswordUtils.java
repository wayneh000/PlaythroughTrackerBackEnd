package io.github.wayneh000.playthroughtracker.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {

	private static PasswordUtils instance = null;
	
	private PasswordEncoder encoder;
	
	private PasswordUtils() {
		encoder = new BCryptPasswordEncoder();
	}
	
	public static PasswordUtils getInstance() {
		if (instance == null)
			instance = new PasswordUtils();
		return instance;
	}
	
	public String hashPassword(String rawPassword) {
		return encoder.encode(rawPassword);
	}
	
	public boolean validatePassword(String rawPassword, String hashedPassword) {
		return encoder.matches(rawPassword, hashedPassword);
	}
}
