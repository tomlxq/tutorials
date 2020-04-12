package com.guava.domain;

import com.guava.validator.FieldsValueMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Passwords do not match!"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "verifyEmail",
                message = "Email addresses do not match!"
        )
})
public class NewUserForm {
    private String email;
    private String verifyEmail;
    private String password;
    private String verifyPassword;
}