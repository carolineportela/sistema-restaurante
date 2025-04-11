package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.InternalServerErrorDetails;

public class InternalServerErrorResponse extends ErrorResponse<InternalServerErrorDetails> {
    public InternalServerErrorResponse(InternalServerErrorDetails details) {
        super(ExceptionCode.INTERNAL_SERVER_ERROR, details);
    }
}
