package ru.skypro.course_work2.service.impl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST)
public class badRequestException extends RuntimeException {
    public badRequestException(String message) {
        super(message);
    }
}
