package com.guava.domain;

import com.guava.validator.ContactNumberConstraint;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/6
 */
@Data
public class UserInfo {
    @NotNull
    @Max(20)
    private String name;
    @ContactNumberConstraint
    private String phone;
}
