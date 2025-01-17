package com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.mapper;

import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.request.ClienteRequestDTO;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.in.dto.response.ClienteResponseDTO;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.out.entities.CartaoEntity;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.adapters.out.entities.ClienteEntity;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.CartaoDomain;
import com.hexagonalJavanauta.operadora_de_cartao_credito.application.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IClienteMapper {
    ClienteEntity paraEntity(ClienteDomain clienteDomain);

    ClienteDomain paraDomain(ClienteEntity clienteEntity);

    @Mapping(target = "cartao", expression = "java(toCartaoEntity(cliente))")
    ClienteDomain toDomain(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteDomain cliente);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoDomain toCartaoDomain(ClienteRequestDTO clienteRequestDTO);
}
