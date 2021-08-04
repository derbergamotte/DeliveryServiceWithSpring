package com.ak.interfaces;

import com.ak.entities.Client;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClientDao extends GenericDao<Client> {

}
