package com.tom.pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.tom.sampleapp.config.MainApplication;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("test_provider")
@PactFolder("pacts")
public class PactProviderLiveTest {

    private static ConfigurableWebApplicationContext application;
    @TestTarget
    public final Target target = new HttpTarget("http", "localhost", 8082, "/spring-rest");

    @BeforeClass
    public static void start() {
        application = (ConfigurableWebApplicationContext) SpringApplication.run(MainApplication.class);
    }

    @State("test GET")
    public void toGetState() {
    }

    @State("test POST")
    public void toPostState() {
    }

}
