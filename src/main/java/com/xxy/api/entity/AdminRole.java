package com.xxy.api.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 794916237250612973L;
    @ApiModelProperty(value="角色ID")
    private Long role_id;
    @ApiModelProperty(value="角色名")
    private String name;
    @ApiModelProperty(value="描述")
    private String description;
    @ApiModelProperty(value="排序")
    private Long orders;
    @ApiModelProperty(value="创建时间")
    private String created_at;
    @ApiModelProperty(value="编辑时间")
    private String updated_at;
}
