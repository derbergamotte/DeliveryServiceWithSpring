package com.ak.implementation;

import com.ak.entities.Client;
import com.ak.interfaces.ClientDao;
import org.springframework.stereotype.Component;

@Component
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {

	private ClientDaoImpl() {
		super(Client.class);
	}
}
