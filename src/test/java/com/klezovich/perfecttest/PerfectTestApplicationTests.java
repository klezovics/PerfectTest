package com.klezovich.perfecttest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

// Run code like "mvn test -Drun.integration.tests=true" to enable this test
@ExtendWith(SpringExtension.class)
@EnabledIfSystemProperty(named="run.integration.tests", matches ="true")
@SpringBootTest
class PerfectTestApplicationTests {

    @Test
    void contextLoads() {
    }
}
