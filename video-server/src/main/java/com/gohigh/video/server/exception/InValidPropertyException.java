package com.gohigh.video.server.exception;

public class InValidPropertyException extends RuntimeException {
	public InValidPropertyException(String reason) {
		super(reason);
	}
}
