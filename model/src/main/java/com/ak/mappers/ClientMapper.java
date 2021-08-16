package com.ak.mappers;

import com.ak.dto.ClientDto;
import com.ak.entities.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper extends EntityMapper<Client, ClientDto>{

}
