package interfaces;

import dto.ClientDto;
import entities.Client;

import java.util.Collection;

public interface ClientService {

    ClientDto add(ClientDto clientDto);

    ClientDto getById(Long id);

    Collection<ClientDto> getAll();

    void remove(Long id);

    void update(ClientDto clientDto);
}
