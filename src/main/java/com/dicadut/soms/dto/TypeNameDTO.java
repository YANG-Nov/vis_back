package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-06 21:53
 */
@ApiModel("数据库中查到返给前端任务类型和构件频率")
@Data
public class TypeNameDTO extends ScanPositionDTO {
    private String codeName;//Jane_TODO 2022/3/17 label
    private String code;//Jane_TODO 2022/3/17 value
}
