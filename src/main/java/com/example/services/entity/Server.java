package com.example.services.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Server {

    private Long id;

    @NotBlank(message = "名称不能为空")
    private String name;

    private String protocol;

    @NotBlank(message = "域名不能为空")
    private String domain;
}
