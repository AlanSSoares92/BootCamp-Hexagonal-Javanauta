package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.controller;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.IClienteService;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.request.ClienteRequestDTO;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.response.ClienteResponseDTO;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.mapper.IClienteMapper;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteServicePort;
    private final IClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteServicePort.solicitarCartao(mapper.toDomain(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteDomain cliente = clienteServicePort.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}