package com.ak.dto;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDto extends BaseDto {

    private String name;
    private Collection<ProductDto> products;
}
