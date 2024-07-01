package com.example.services.entity;


import lombok.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Env implements Serializable {

    private int id;

    private String name;
}