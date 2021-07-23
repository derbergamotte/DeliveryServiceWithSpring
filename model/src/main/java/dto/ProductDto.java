package dto;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends BaseDto {

    private String name;
    private Collection<CategoryDto> categories;
    private Collection<StorageDto> storages;
    private Collection<AttributeDto> attributes;
    private String information;
}
