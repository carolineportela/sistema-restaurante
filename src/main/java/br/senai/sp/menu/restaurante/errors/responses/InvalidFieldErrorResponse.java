package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.InvalidFieldErrorDetails;

public class InvalidFieldErrorResponse extends ErrorResponse<InvalidFieldErrorDetails> {
    public InvalidFieldErrorResponse(InvalidFieldErrorDetails details) {
        super(ExceptionCode.API_FIELDS_INVALID, details);
    }
}
