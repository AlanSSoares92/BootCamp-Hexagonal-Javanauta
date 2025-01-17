package com.hexagonalJavanauta.operadora_de_cartao_credito.application.porters.out;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;

import java.util.Optional;

public interface IClienteRepository {

    ClienteDomain salvar(ClienteDomain clienteDomain);

    Boolean buscarUsuarioPorEmail(String email);

   Optional <ClienteDomain> buscarUsuarioPorCpf(String cpf);
}
