package com.example.services.dto;


import com.example.services.entity.Server;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerDto extends Server {

    private Long envId;

    private String label;
}
