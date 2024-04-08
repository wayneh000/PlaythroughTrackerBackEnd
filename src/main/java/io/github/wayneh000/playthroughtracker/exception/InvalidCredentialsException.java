package io.github.wayneh000.playthroughtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Invalid username or password. ")
public class InvalidCredentialsException extends PlaythroughTrackerException {

}
