package it.unibo.exception.fakenetwork.impl;

import java.io.IOException;

public final class NetworkException extends IOException {
 

    public NetworkException(final String message) {
        super("Network error while sending message: " + message);
    }

    public NetworkException() {
        super("Network error: no response");
    }
}