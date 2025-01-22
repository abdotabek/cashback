package org.example.cashback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorDTO {

    private String title;
    private String message;
    private HttpStatus status;
    private LocalDateTime localDateTime;
}
