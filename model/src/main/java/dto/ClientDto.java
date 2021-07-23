package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDto extends BaseDto {

    private String name;
    private String phone;
    private String address;
    private Collection<OrderDto> orders;
}
