package com.sbt.javaschool.exceptions;

public class AccountIsLockedException extends IllegalAccessException{
    /**
     * Constructs an <code>IllegalAccessException</code> with a detail message.
     *
     * @param s the detail message.
     */
    public AccountIsLockedException(String s) {
        super(s);
    }
}
