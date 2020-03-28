package com.tom.domain;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserBean {
    String username;
    String password;

    public boolean login() {
        log.info("{}", JSON.toJSONString(this, true));
        if (StringUtils.equals(this.username, "tom") && StringUtils.equals(this.password, "123456")) {
            return true;
        }
        return false;
    }
}
