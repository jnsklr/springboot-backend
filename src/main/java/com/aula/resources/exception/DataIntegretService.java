package com.aula.resources.exception;

public class DataIntegretService extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegretService(String msg) {
		super(msg);
	}

	public DataIntegretService(String msg, Throwable cause) {
		super(msg, cause);
	}

}
