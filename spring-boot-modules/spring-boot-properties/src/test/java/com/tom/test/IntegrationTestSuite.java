package com.tom.test;

import com.tom.properties.basic.ExtendedPropertiesWithJavaIntegrationTest;
import com.tom.properties.basic.PropertiesWithMultipleXmlsIntegrationTest;
import com.tom.properties.basic.PropertiesWithXmlIntegrationTest;
import com.tom.properties.external.ExternalPropertiesWithJavaIntegrationTest;
import com.tom.properties.external.ExternalPropertiesWithMultipleXmlsIntegrationTest;
import com.tom.properties.external.ExternalPropertiesWithXmlManualTest;
import com.tom.properties.multiple.MultiplePlaceholdersXmlConfigIntegrationTest;
import com.tom.properties.multiple.MultiplePropertiesXmlConfigIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //@formatter:off
        PropertiesWithXmlIntegrationTest.class,
        ExternalPropertiesWithJavaIntegrationTest.class,
        ExternalPropertiesWithMultipleXmlsIntegrationTest.class,
        ExternalPropertiesWithXmlManualTest.class,
        ExtendedPropertiesWithJavaIntegrationTest.class, MultiplePropertiesXmlConfigIntegrationTest.class,
        PropertiesWithMultipleXmlsIntegrationTest.class, MultiplePlaceholdersXmlConfigIntegrationTest.class
})// @formatter:on
public final class IntegrationTestSuite {
    //
}
