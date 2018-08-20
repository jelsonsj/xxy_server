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
public class AdminUser implements Serializable {

    private static final long serialVersionUID = 7815280683116766666L;

    @ApiModelProperty(value="管理员id")
    private Long user_id;

    @ApiModelProperty(value="用户名")
    private String username;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="盐")
    private String salt;

    @ApiModelProperty(value="真实姓名")
    private String realname;

    @ApiModelProperty(value="头像")
    private String avatar;

    @ApiModelProperty(value="电话")
    private String phone;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="性别")
    private Integer sex;

    @ApiModelProperty(value="状态")
    private Integer locked;

    @ApiModelProperty(value="是否超级管理员")
    private Integer is_super;

    @ApiModelProperty(value="创建时间")
    private String created_at;

    @ApiModelProperty(value="更新时间")
    private String updated_at;
}
