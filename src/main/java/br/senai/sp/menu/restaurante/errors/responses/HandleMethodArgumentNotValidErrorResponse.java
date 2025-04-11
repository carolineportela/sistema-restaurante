package br.senai.sp.menu.restaurante.errors.responses;

import br.senai.sp.menu.restaurante.errors.ErrorResponse;
import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import br.senai.sp.menu.restaurante.errors.details.HandleMethodArgumentNotValidErrorDetails;

public class HandleMethodArgumentNotValidErrorResponse extends ErrorResponse<HandleMethodArgumentNotValidErrorDetails> {
    public HandleMethodArgumentNotValidErrorResponse(HandleMethodArgumentNotValidErrorDetails details) {
        super(ExceptionCode.API_FIELDS_INVALID, details);
    }
}
