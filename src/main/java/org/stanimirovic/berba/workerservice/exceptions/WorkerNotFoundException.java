package org.stanimirovic.berba.workerservice.exceptions;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(String message) {
        super(message);
    }
}
