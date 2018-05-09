package com.aula.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandertError {

	private List<FieldMessage> fields = new ArrayList<>();

	public ValidationError(Integer status, String msg) {
		super(status, msg);
		// TODO Auto-generated constructor stub
	}

	public ValidationError() {

	}

	public List<FieldMessage> getErros() {
		return fields;
	}

	public void addError(String fildName, String message) {
		this.fields.add(new FieldMessage(fildName, message));
	}

}
