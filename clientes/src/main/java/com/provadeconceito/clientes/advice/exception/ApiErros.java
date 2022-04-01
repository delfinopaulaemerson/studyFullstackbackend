package com.provadeconceito.clientes.advice.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
@Getter
public class ApiErros {

    private List<String> erros;

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErros(String message) {
        this.erros = Arrays.asList(message);
    }
}
