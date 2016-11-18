/**
 * 
 */
package com.test.java.rest.exception;

/**
 * @author Hemraj
 *
 */
public class DatabaseException extends Exception {
	private static final long	serialVersionUID	= 1L;

	private String	          errorCode;

	public DatabaseException(String specificMessage) {
		super(specificMessage);
	}

	public DatabaseException(String specificMessage, Throwable e) {
		super(specificMessage, e);
	}

	public DatabaseException(String specificMessage, String errorCode) {
		super(specificMessage);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
