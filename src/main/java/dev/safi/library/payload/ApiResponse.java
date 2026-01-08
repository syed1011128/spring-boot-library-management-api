package dev.safi.library.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
}
