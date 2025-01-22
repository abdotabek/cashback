package org.example.cashback.exception;

import org.example.cashback.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionUtil {
    public static NotFoundExceptions throwNotFoundException(String message) {

        ErrorDTO errorDTO = ErrorDTO
                .builder()
                .title("Resource Not Found")
                .message(message)
                .status(HttpStatus.NOT_FOUND)
                .localDateTime(LocalDateTime.now())
                .build();
        throw new NotFoundExceptions(errorDTO, message);
    }

    public static ConflictException throwConflictException(String message) {

        ErrorDTO errorDTO = ErrorDTO
                .builder()
                .title("Conflict error")
                .message(message)
                .status(HttpStatus.CONFLICT)
                .localDateTime(LocalDateTime.now())
                .build();
        throw new ConflictException(errorDTO, message);
    }

    public static BadRequestException throwBadRequestException(String message) {

        ErrorDTO errorDTO = ErrorDTO
                .builder()
                .title("Bad Request")
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .localDateTime(LocalDateTime.now())
                .build();
        throw new BadRequestException(errorDTO, message);
    }
}
