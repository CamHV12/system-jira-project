package vn.api.spring.business.domain.exception;

import lombok.Getter;

@Getter
public class NoSuchElementException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchElementException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchElementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchElementException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchElementException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchElementException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
