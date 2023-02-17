package com.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@Data
@ToString
public class MyResponseEntity<T> {
    T body;
    String message;
    HttpStatus httpStatus;
    public MyResponseEntity(T body, String message){
        this.body=body;
        this.message=message;

    }
}
