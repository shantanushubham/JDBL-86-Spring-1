package org.geeksforgeeks.jdbl86.execptions;

public class DuplicateEntryException extends RuntimeException {

    public DuplicateEntryException(String message) {
        super(message);
    }
}
