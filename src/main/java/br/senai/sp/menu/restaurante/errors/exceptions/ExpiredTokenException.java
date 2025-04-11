package br.senai.sp.menu.restaurante.errors.exceptions;

import br.senai.sp.menu.restaurante.errors.ExceptionCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class ExpiredTokenException extends RuntimeException {
    private final ExceptionCode code;

    public ExpiredTokenException() {
        super(ExceptionCode.EXPIRED_TOKEN.toString());
        this.code = ExceptionCode.EXPIRED_TOKEN;
    }
    public String getCodeAsString() {
        return code.toString();
    }
}
