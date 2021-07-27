package com.ak.implementation;

import java.util.Collection;

import com.ak.dto.ClientDto;
import com.ak.entities.Client;
import com.ak.interfaces.ClientDao;
import com.ak.interfaces.ClientService;
import com.ak.mappers.ClientMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    public ClientDto add(ClientDto clientDto) {
        return ClientMapper.INSTANCE.toDto(clientDao.add(ClientMapper.INSTANCE.toEntity(clientDto)));
    }

    public ClientDto getById(Long id) {
        return ClientMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<ClientDto> getAll() {
        return ClientMapper.INSTANCE.toDto(clientDao.getAll());
    }

    public void remove(Long id) {
        clientDao.remove(id);
    }

    public void update(ClientDto clientDto) {
        if (clientDto.getId() == null) {
            return;
        }
        Client client = getEntityById(clientDto.getId());
        if (StringUtils.isNotEmpty(clientDto.getName())) {
            client.setName(clientDto.getName());
        }
        if (StringUtils.isNotEmpty(clientDto.getPhone())) {
            client.setPhone(clientDto.getPhone());
        }
        if (StringUtils.isNotEmpty(clientDto.getAddress())) {
            client.setAddress(clientDto.getAddress());
        }
        clientDao.update(client);
    }

    private Client getEntityById(Long id) {
        return clientDao.get(id);
    }
}
