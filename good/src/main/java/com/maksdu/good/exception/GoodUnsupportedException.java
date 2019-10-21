package com.maksdu.good.exception;

public class GoodUnsupportedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public GoodUnsupportedException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
    
}
