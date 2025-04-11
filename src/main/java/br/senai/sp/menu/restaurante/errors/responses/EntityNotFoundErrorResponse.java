package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.EntityNotFoundErrorDetails;

public class EntityNotFoundErrorResponse extends ErrorResponse<EntityNotFoundErrorDetails> {
    public EntityNotFoundErrorResponse(EntityNotFoundErrorDetails details) {
        super(ExceptionCode.ENTITY_NOT_FOUND, details);
    }
}
