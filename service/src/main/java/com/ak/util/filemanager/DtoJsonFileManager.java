package com.ak.util.filemanager;

import com.ak.dto.BaseDto;

public interface DtoJsonFileManager {

    void save(BaseDto dto);
    BaseDto get(BaseDto dto);
}
