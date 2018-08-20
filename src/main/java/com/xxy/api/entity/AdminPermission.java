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
public class AdminPermission implements Serializable {

    private static final long serialVersionUID = -1886239435274034401L;

    @ApiModelProperty(value="权限id")
    private Long permission_id;
    @ApiModelProperty(value="父级id")
    private Long pid;
    @ApiModelProperty(value="名称")
    private String name;
    @ApiModelProperty(value="类型")
    private Integer type;
    @ApiModelProperty(value="权限值")
    private String permission_value;
    @ApiModelProperty(value="路由路径")
    private String uri;
    @ApiModelProperty(value="图标")
    private String icon;
    @ApiModelProperty(value="状态")
    private Integer status;
    @ApiModelProperty(value="排序")
    private Long orders;
    @ApiModelProperty(value="创建时间")
    private String created_at;
    @ApiModelProperty(value="更新时间")
    private String updated_at;
}
