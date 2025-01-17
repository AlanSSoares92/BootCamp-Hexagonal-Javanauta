package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.out;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.mapper.IClienteMapper;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.out.repositories.IClienteJpaRepository;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.porters.out.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {

    private final IClienteJpaRepository repository;
    private final IClienteMapper mapper;

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        return mapper.paraDomain(repository.save(mapper.paraEntity(clienteDomain)));
    }

    @Override
    public Boolean buscarUsuarioPorEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf) {
        return repository.findByCpf(cpf).map(mapper::paraDomain);
    }
}
