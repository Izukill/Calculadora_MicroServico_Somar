package com.ifpb.v100.dto;

import jakarta.validation.constraints.NotNull;

public record SomarRequestDTO(
    @NotNull(message = "O campo 'a' é obrigatório.")
    Double a,

    @NotNull(message = "O campo 'b' é obrigatório.")
    Double b
) {}
