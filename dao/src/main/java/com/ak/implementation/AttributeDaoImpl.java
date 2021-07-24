package com.ak.implementation;

import com.ak.entities.Attribute;
import com.ak.interfaces.AttributeDao;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeDaoImpl extends GenericDaoImpl<Attribute> implements AttributeDao {

    private AttributeDaoImpl() {
        super(Attribute.class);
    }

    public Attribute getAttributeByName(String attributeName) {
        return getAll().stream()
                .filter(a -> attributeName.equals(a.getName()))
                .findAny()
                .orElse(null);
    }
}
