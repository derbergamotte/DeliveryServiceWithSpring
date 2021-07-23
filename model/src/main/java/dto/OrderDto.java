package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto {

    private StorageDto storage;
    private ClientDto client;
    private Integer quantity;
}
