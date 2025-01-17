package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;

public interface IClienteService {
    ClienteDomain solicitarCartao(ClienteDomain clienteDomain);

    ClienteDomain buscarPorCpf(String cpf);
}
