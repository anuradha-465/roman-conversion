package com.service.romanconversion.model;

import lombok.*;
import java.io.Serializable;

/*
 This is the model class of the result.ß
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Result implements Serializable {
    private int input;
    private String output;

    public Result(final int input, final String output) {
        this.input = input;
        this.output = output;
    }
}
