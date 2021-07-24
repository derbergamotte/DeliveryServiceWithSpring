package com.ak.interfaces;

import com.ak.dto.ClientDto;

import java.util.Collection;

public interface ClientService {

    ClientDto add(ClientDto clientDto);

    ClientDto getById(Long id);

    Collection<ClientDto> getAll();

    void remove(Long id);

    void update(ClientDto clientDto);
}
