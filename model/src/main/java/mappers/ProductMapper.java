package mappers;

import dto.ProductDto;
import entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "id", target = "id")
    ProductDto toDto(Product entity);

    Collection<ProductDto> toDto(Collection<Product> products);

    Product toEntity(ProductDto dto);
}
