package implementation;

import entities.Attribute;
import interfaces.AttributeDao;

public class AttributeDaoImpl extends GenericDaoImpl<Attribute> implements AttributeDao {

    private AttributeDaoImpl() {
        super(Attribute.class);
    }

    private static AttributeDaoImpl attributeDao;

    public static AttributeDao getAttributeDao() {
        if (attributeDao == null) {
            attributeDao = new AttributeDaoImpl();
        }
        return attributeDao;
    }

    public Attribute getAttributeByName(String attributeName) {
        return getAll().stream()
                .filter(a -> attributeName.equals(a.getName()))
                .findAny()
                .orElse(null);
    }
}
