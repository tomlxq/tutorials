package com.tom.jackson.test;

import com.tom.jackson.sandbox.JacksonPrettyPrintUnitTest;
import com.tom.jackson.sandbox.SandboxUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ // @formatter:off
        JacksonPrettyPrintUnitTest.class
        , SandboxUnitTest.class
}) // @formatter:on
public class UnitTestSuite {
}