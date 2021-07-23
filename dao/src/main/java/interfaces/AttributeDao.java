package interfaces;

import entities.Attribute;

public interface AttributeDao extends GenericDao<Attribute> {

	Attribute getAttributeByName(String attributeName);
}
