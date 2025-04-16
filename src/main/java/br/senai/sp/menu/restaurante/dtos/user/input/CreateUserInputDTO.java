package br.senai.sp.menu.restaurante.dtos.user.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserInputDTO {

    @NotBlank(message = "Name is mandatory")
    @Schema(example = "Caroline", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "must be a well-formed email address")
    @Schema(example = "caroline@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Schema(example = "Password123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NotBlank(message = "User type is required")
    @Schema(example = "ADMIN", requiredMode = Schema.RequiredMode.REQUIRED)
    private String role;
}
