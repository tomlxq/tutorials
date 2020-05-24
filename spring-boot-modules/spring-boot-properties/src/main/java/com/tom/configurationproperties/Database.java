package com.tom.configurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "database")
@Getter
@Setter
public class Database {
    String url;
    String username;
    String password;
}