package org.stanimirovic.berba.workerservice.exceptions;

public class WorkerNotAssociatedWithUserException extends RuntimeException {
    public WorkerNotAssociatedWithUserException(String message) {
        super(message);
    }
}
