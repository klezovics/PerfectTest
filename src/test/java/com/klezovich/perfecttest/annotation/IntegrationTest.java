package com.klezovich.perfecttest.annotation;

import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * To run unit tests with this annotation call maven with the following command
 * "mvn test -Drun.integration.tests=true"
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnabledIfSystemProperty(named = "run.integration.tests", matches = "true")
public @interface IntegrationTest {
}
