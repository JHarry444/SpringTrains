package com.qa.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TrainYardNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203668626229982433L;

	
}
