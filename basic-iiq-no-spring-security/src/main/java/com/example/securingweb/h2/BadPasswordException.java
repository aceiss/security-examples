package com.example.securingweb.h2;

public class BadPasswordException extends Exception {

    /**
     * Constructs a <code>UsernameNotFoundException</code> with the specified message.
     * @param msg the detail message.
     */
    public BadPasswordException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code UsernameNotFoundException} with the specified message and root
     * cause.
     * @param msg the detail message.
     * @param cause root cause
     */
    public BadPasswordException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
