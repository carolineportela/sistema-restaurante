package br.senai.sp.menu.restaurante.rest.specs;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseBadRequest;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseDuplicatedResource;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseForbidden;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseInternalServerError;
import br.senai.sp.menu.restaurante.rest.specs.commons.response.error.ApiResponseNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Tag(name = "2. User", description = "User operations")
@ApiResponseInternalServerError
public interface UserControllerSpecs {

    @Operation(summary = "Create user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created")
    })
    @ResponseStatus(HttpStatus.CREATED)
    void create(
            @Parameter(
                    required = true,
                    schema = @Schema(implementation = CreateUserInputDTO.class)
            )
            @RequestBody CreateUserInputDTO body
    );

    @Operation(summary = "Find user by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ApiResponse(responseCode = "200", description = "Ok", content = {
            @Content(schema = @Schema(implementation = UserDetailedOutputDTO.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE)
    })
    @SecurityRequirement(name = "jwt")
    @ResponseStatus(HttpStatus.OK)
    UserDetailedOutputDTO findById(@PathVariable UUID id);


    @Operation(summary = "Find all users")
    @ApiResponseForbidden
    @ApiResponse(responseCode = "200", description = "Ok", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserDetailedOutputDTO.class))
    })
    @SecurityRequirement(name = "jwt")
    @ResponseStatus(HttpStatus.OK)
    List<UserDetailedOutputDTO> findAll();


}
