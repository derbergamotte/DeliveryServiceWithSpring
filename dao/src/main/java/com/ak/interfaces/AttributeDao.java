package com.ak.interfaces;

import com.ak.entities.Attribute;

public interface AttributeDao extends GenericDao<Attribute> {

	Attribute getAttributeByName(String attributeName);
}
