package com.maksdu.good.exception;

public class GoodUnsupportException extends RuntimeException {

    private String message;

    public GoodUnsupportException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }￿

}
