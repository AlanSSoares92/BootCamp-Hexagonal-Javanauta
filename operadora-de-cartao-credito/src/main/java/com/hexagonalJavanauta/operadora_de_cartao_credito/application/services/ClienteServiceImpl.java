package com.hexagonalJavanauta.operadora_de_cartao_credito.application.services;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.IClienteService;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.CartaoDomain;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.porters.out.IClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;
    private final GeraDadosCartaoService geraCartao;

    public ClienteServiceImpl(IClienteRepository clienteRepository, GeraDadosCartaoService geraCartao) {
        this.clienteRepository = clienteRepository;
        this.geraCartao = geraCartao;
    }

    @Override
    public ClienteDomain solicitarCartao(ClienteDomain cliente) {
        if (clienteRepository.buscarUsuarioPorEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão.");
        }

        CartaoDomain cartao = geraCartao.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.salvar(cliente);

    }
    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
        return clienteRepository.buscarUsuarioPorCpf(cpf).
                orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}