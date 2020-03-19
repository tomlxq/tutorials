package com.tom.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class TomPostgresqlContainer extends PostgreSQLContainer<TomPostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";

    private static TomPostgresqlContainer container;


    private TomPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static TomPostgresqlContainer getInstance() {
        if (container == null) {
            container = new TomPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}