package edu.uel.proteo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends StdException {

	public RecordNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(resourceName, fieldName, fieldValue);
	}
}
