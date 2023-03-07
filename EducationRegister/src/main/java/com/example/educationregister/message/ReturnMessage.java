package com.example.educationregister.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ReturnMessage {

    public final String code;

    public final String message;

    public final Severity severity;

    @JsonCreator
    ReturnMessage(@JsonProperty("code") String code, @JsonProperty("message") String message, @JsonProperty("severity") Severity severity) {

        this.code = code;
        this.message = message;
        this.severity = severity;
    }

}
