package com.tom.system;

public class EnvironmentVariables {
    public String getPath() {
        return System.getenv("PATH");
    }
}
