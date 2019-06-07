package com.notekeepingapp.NoteKeepingAppDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoteNotFoundException extends Exception {

    private String errorMessage;

    public NoteNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public NoteNotFoundException() {
        super();
    }
}
