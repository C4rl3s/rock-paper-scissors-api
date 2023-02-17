package com.challenge.rockpaperscissors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Entity Not Found")
public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

}