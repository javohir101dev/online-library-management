package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private boolean success;
    private String message;
    private T data;
    private List<ValidDto> error;
    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto(T data) {
        this.success = true;
        this.data = data;
    }

    public ResponseDto(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseDto(boolean success, String message, List<ValidDto> error) {
        this.success = success;
        this.message = message;
        this.error = error;
    }
}

