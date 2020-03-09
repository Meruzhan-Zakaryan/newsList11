package com.example.newslistfragment;

public class NotBaseTypeException extends RuntimeException {

    private static final String EXCEPTION_DESCRIPTION = "activity must extends from BaseActivity";

    public NotBaseTypeException() {
        super(EXCEPTION_DESCRIPTION);
    }
}
