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
public class AdminRolePermission implements Serializable {

    private static final long serialVersionUID = -3766420366059793351L;
    @ApiModelProperty(value="角色权限id")
    private Long role_permission_id;
    @ApiModelProperty(value="角色id")
    private Long role_id;
    @ApiModelProperty(value="权限id")
    private Long permission_id;
}
