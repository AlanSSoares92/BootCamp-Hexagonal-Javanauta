package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.response;

public record CartaoResponseDTO(String numero,
                                String dataExpiracao,
                                String cvv,
                                double limite) {}