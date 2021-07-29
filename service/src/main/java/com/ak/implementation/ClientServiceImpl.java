package com.ak.implementation;

import com.ak.dto.ClientDto;
import com.ak.entities.Client;
import com.ak.interfaces.ClientDao;
import com.ak.interfaces.ClientService;
import com.ak.mappers.ClientMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends EntityServiceImpl<Client, ClientDto> implements ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ClientMapper clientMapper;

    public ClientDto update(ClientDto clientDto) {
        if (clientDto.getId() == null) {
            return clientDto;
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
        return clientMapper.toDto(clientDao.update(client));
    }
}
