package com.example.services.entity;


import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Env implements Serializable {

    private int id;

    private String name;
}