package br.senai.sp.menu.restaurante.dtos.user.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailedOutputDTO {

    private UUID idUser;

    @Schema(example = "Caroline")
    private String name;

    @Schema(example = "caroline@gmail.com")
    private String email;

}
