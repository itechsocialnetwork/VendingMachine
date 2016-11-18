/**
 * 
 */
package com.test.java.rest.exception;

/**
 * @author Hemraj
 *
 */
public class ContainerEmptyException extends Exception {
	private static final long	serialVersionUID	= 1L;

	private String	          errorCode;

	public ContainerEmptyException(String specificMessage) {
		super(specificMessage);
	}

	public ContainerEmptyException(String specificMessage, Throwable e) {
		super(specificMessage, e);
	}

	public ContainerEmptyException(String specificMessage, String errorCode) {
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
