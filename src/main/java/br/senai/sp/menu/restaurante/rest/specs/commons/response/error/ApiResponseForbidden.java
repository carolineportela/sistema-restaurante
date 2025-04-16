package br.senai.sp.menu.restaurante.rest.specs.commons.response.error;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@ApiResponse(
        responseCode = "403",
        description = "${springdoc.swagger-config.responses.error.403}",
        content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                        summary = "User does not have permission",
                        value = "{ \"error\": \"FORBIDDEN\", \"details\": {} }"
                ),
                schema = @Schema(implementation = ErrorResponse.class)
        )
)


public @interface ApiResponseForbidden {
}

