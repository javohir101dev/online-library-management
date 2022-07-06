package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto <T>{

    private boolean success;
    private String message;
    private T data;

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto(T data) {
        this.success = true;
        this.data = data;
    }
}

