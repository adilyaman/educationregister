package com.example.educationregister;

import com.example.educationregister.message.ReturnMessages;
import lombok.Data;

import java.util.Objects;

@Data
public class RestResponse<T> {

    private T data;

    private ReturnMessages returnMessages;

    public RestResponse(T data) {
        this.data = data;
    }

    public static <T> RestResponse<T> of(T t) {
        return new RestResponse<>(t);
    }

    public static RestResponse<Void> empty() {
        return new RestResponse<>(null);
    }

    public void setReturnMessages(ReturnMessages returnMessages) {

        if (Objects.nonNull(returnMessages)) {
            this.returnMessages = returnMessages;
        }
    }




}
