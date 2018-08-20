package com.xxy.api.entity;

import io.swagger.annotations.Api;
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
public class AdminUserRole implements Serializable {

    private static final long serialVersionUID = -8779490086284562890L;
    @ApiModelProperty(value="用户角色id")
    private Long user_role_id;
    @ApiModelProperty(value="用户id")
    private Long user_id;
    @ApiModelProperty(value="角色id")
    private Long role_id;


}
