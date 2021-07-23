package implementation;

import dto.ClientDto;
import interfaces.ClientDao;
import interfaces.ClientService;

public class main {
    public static void main(String[] args) {
        ClientService clientService = ClientServiceImpl.getClientService();
        ClientDto dto = new ClientDto();
        clientService.add(dto);

    }
}
