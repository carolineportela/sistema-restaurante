package br.senai.sp.menu.restaurante.errors.exceptions;

import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class ForbiddenException extends RuntimeException {
    private final ExceptionCode code;
    private final String[] customMessageFields;

    public ForbiddenException() {
        super(ExceptionCode.FORBIDDEN.toString());
        this.code = ExceptionCode.FORBIDDEN;
        this.customMessageFields = new String[0];
        log.error("Forbidden request", this);
    }

    public ForbiddenException(ExceptionCode exceptionCode) {
        super(exceptionCode.toString());
        this.code = exceptionCode;
        this.customMessageFields = new String[0];
        log.error("Forbidden request", this);
    }

    public String getCodeAsString() {
        return code.toString();
    }

    public Object[] getArgs() {
        return customMessageFields;
    }
}
