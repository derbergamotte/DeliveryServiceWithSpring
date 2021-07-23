package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class StoreDto extends BaseDto {

    private String name;
    private String phone;
    private String address;
    private Collection<StorageDto> storages;
}
