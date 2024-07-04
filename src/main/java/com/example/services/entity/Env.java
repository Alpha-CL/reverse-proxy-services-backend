package com.example.services.entity;


import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Env implements Serializable {

    private int id;

    @NotBlank(message = "name 不能为空")
    private String name;
}