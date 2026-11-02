package com.ifpb.v100.dto;

public record ErroResponseDTO(
    ErroDetalhe erro
) {
    public record ErroDetalhe(
        String codigo,
        String mensagem
    ) {}

    public ErroResponseDTO(String codigo, String mensagem) {
        this(new ErroDetalhe(codigo, mensagem));
    }
}