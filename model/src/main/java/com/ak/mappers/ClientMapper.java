package com.ak.mappers;

import com.ak.dto.ClientDto;
import com.ak.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface ClientMapper extends EntityMapper<Client, ClientDto>{

}
