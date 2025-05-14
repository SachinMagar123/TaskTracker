package com.sachin.task.domain;

public record ErrorResponse(
        int status,
        String message ,
        String details
) {
}
