package com.ak.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class StorageDto extends BaseDto {

    private StoreDto store;
    private ProductDto product;
    private Integer quantity;
    private Integer price;
    private Collection<OrderDto> orders;
}
