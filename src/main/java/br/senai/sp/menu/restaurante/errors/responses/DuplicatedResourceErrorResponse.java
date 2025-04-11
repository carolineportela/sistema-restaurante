package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.DuplicatedResourceErrorDetails;

public class DuplicatedResourceErrorResponse extends ErrorResponse<DuplicatedResourceErrorDetails> {
    public DuplicatedResourceErrorResponse(DuplicatedResourceErrorDetails details) {
        super(ExceptionCode.DUPLICATED_RESOURCE, details);
    }
}
