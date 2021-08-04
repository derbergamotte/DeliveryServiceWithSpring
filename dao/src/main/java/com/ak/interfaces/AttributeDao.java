package com.ak.interfaces;

import com.ak.entities.Attribute;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AttributeDao extends GenericDao<Attribute> {

}
