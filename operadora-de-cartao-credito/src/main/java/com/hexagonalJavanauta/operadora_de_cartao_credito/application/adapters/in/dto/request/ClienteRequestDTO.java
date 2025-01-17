package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.request;

public record ClienteRequestDTO (String nome,
                                 String email,
                                 Integer idade,
                                 String cpf,
                                 EnderecoRequestDTO endereco,
                                 double rendaMensal,
                                 String dataVencimentoFatura){}