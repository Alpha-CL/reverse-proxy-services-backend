package com.example.services.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Server {

    private int id;

    @NotBlank(message = "name 不能为空")
    private String name;
}
