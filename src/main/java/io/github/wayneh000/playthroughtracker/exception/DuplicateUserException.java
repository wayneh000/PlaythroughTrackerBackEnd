package io.github.wayneh000.playthroughtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Username already exists!")
public class DuplicateUserException extends PlaythroughTrackerException {

}
