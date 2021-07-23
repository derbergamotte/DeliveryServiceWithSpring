package mappers;

import dto.AttributeDto;
import entities.Attribute;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttributeMapper {

    AttributeMapper INSTANCE = Mappers.getMapper(AttributeMapper.class);

    @Mapping(source = "id", target = "id")
    @InheritInverseConfiguration
    AttributeDto toDto(Attribute entity);

    Attribute toEntity(AttributeDto dto);
}
