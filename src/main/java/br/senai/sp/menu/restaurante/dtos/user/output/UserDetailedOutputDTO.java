package br.senai.sp.menu.restaurante.dtos.user.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailedOutputDTO {

    private UUID idUser;
    private String name;
    private String email;

}
