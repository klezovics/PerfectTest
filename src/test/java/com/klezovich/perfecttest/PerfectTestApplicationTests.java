package com.klezovich.perfecttest;

import com.klezovich.perfecttest.annotation.IntegrationTest;
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
@IntegrationTest
@SpringBootTest
class PerfectTestApplicationTests {

    @Test
    void contextLoads() {
    }
}
