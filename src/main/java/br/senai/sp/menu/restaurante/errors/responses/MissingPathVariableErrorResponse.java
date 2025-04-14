package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.MissingPathVariableErrorDetails;

public class MissingPathVariableErrorResponse extends ErrorResponse<MissingPathVariableErrorDetails> {
    public MissingPathVariableErrorResponse(MissingPathVariableErrorDetails details) {
        super(ExceptionCode.API_FIELDS_INVALID, details);
    }
}
