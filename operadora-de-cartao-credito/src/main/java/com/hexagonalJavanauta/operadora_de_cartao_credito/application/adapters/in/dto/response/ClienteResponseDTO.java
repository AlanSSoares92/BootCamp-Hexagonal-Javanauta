package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.response;

public record ClienteResponseDTO(String nome,
                                 String email,
                                 Integer idade,
                                 String cpf,
                                 CartaoResponseDTO cartao){}