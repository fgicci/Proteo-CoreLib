package edu.uel.proteo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class RecordExistsException extends StdException {

	public RecordExistsException(String resourceName, String fieldName, String fieldValue) {
		super(resourceName, fieldName, fieldValue);
	}
}
