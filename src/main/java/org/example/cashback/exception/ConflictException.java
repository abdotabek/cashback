package org.example.cashback.exception;

import lombok.Getter;
import lombok.Setter;
import org.example.cashback.dto.ErrorDTO;

@Getter
@Setter
public class ConflictException extends RuntimeException {

    private ErrorDTO errorDTO;

    public ConflictException(ErrorDTO error, String message) {
        super(message);
        this.errorDTO = error;
    }
}
