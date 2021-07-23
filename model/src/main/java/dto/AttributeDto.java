package dto;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class AttributeDto extends BaseDto {
	
	private String name;
	private Collection<ProductDto> products;
}
