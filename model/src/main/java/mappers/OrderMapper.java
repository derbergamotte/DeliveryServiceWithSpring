package mappers;

import dto.OrderDto;
import entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "id", target = "id")
    OrderDto toDto(Order order);
    @Mapping(source = "id", target = "id")
    Order toEntity(OrderDto dto);
}
