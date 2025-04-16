//package br.senai.sp.menu.restaurante.rest.specs;
//
//import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
//import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
//import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.*;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Tag(name = "1. Auth", description = "Operações de autenticação")
//@ApiResponseBadRequest
//@ApiResponseInternalServerError
//public interface AuthControllerSpecs {
//
//    @Operation(summary = "Realiza login e retorna token JWT")
//    @ApiResponseUnauthorized
//    @ApiResponseForbidden
//    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso", content = @Content(
//            mediaType = MediaType.APPLICATION_JSON_VALUE,
//            schema = @Schema(implementation = LoginOutputDTO.class)
//    ))
//    LoginOutputDTO login(@RequestBody @Valid LoginInputDTO request);
//}

package br.senai.sp.menu.restaurante.rest.specs;

import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseBadRequest;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseForbidden;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseInternalServerError;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseUnauthorized;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "1. Auth", description = "Auth operations")
@ApiResponseBadRequest
@ApiResponseInternalServerError
public interface AuthControllerSpecs {

    @Operation(summary = "Login")
    @ApiResponseForbidden
    @ApiResponseUnauthorized
    @ApiResponse(responseCode = "200", description = "Ok", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = LoginOutputDTO.class))
    })
    LoginOutputDTO login(@RequestBody LoginInputDTO request);
}
