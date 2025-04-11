package br.senai.sp.menu.restaurante.errors.exceptions;

import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class InvalidFieldException extends RuntimeException {
    private final ExceptionCode code;
    private final String[] fields;

    public InvalidFieldException(ExceptionCode code, String... customMessageFields) {
        super("Invalid fields");
        this.code = code;
        this.fields = customMessageFields;
    }

    public String getCodeAsString() {
        return code.toString();
    }
}
