package com.example.services.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {

    private Long id;

    @NotBlank(message = "name 不能为空")
    private String name;
}
