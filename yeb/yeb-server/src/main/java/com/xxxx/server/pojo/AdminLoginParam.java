package com.xxxx.server.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName: AdminLoginParam
 * @Description: 用户实体类
 * @author: solfeng
 * @date: 2021/7/7  20:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Api(value = "AdminLogin对象")
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;

}
