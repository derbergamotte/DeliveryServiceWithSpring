package implementation;

import entities.Client;
import interfaces.ClientDao;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {

	private ClientDaoImpl() {
		super(Client.class);
	}
	
	private static ClientDaoImpl clientDao;
	
	public static ClientDao getClientDao() {
		if (clientDao == null) {
			clientDao = new ClientDaoImpl();
		}
		return clientDao;
	}
}
