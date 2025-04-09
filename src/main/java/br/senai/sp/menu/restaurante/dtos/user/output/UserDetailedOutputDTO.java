package br.senai.sp.menu.restaurante.dtos.user.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailedOutputDTO {
//    private Long id;
//    private String name;
//    private String email;

    private Long userId;
    private String userName;
    private String email;
}
