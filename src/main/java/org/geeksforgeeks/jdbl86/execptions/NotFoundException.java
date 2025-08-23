package org.geeksforgeeks.jdbl86.execptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class NotFoundException extends RuntimeException {

    private String message;
    private Class<?> notFound;
    private String fieldUsedToFind;
    private Object valueUsedToFind;

    public NotFoundException(Class<?> notFound, String fieldUsedToFind, Object valueUsedToFind) {
        this.notFound = notFound;
        this.fieldUsedToFind = fieldUsedToFind;
        this.valueUsedToFind = valueUsedToFind;
        this.message =  this.notFound.getSimpleName() + " was not found with " + this.fieldUsedToFind
                + "=" + this.valueUsedToFind;
        log.error(this.message, this);
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
