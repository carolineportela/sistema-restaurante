package br.senai.sp.menu.restaurante.errors.details;

import java.util.Map;

public record DuplicatedResourceErrorDetails(
        Class<?> resourceClass,
        Map<String, Object> parameters
) {
}
