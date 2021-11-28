package com.dicadut.soms.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 16:59
 */
@Data
public class DieaseDTO {


    private String name;
    private Integer isGood;
    private String damageType;
    private String damageExtent;
    private String damagePosition;
    private String Note;


}
