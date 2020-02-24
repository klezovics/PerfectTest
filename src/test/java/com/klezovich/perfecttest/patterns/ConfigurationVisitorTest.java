package com.klezovich.perfecttest.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationVisitorTest {

    private final ConfigurationVisitor visitor = new ConfigurationVisitor();

    @Test
    public void testVisitor() {
        ClientOne c1 = new ClientOne();
        c1.accept(visitor);
        assertEquals(c1.getUserName(), "User1");
        assertEquals(c1.getPassword(), "111");

        ClientTwo c2 = new ClientTwo();
        c2.accept(visitor);
        assertEquals(c2.getUserName(), "User2");
        assertEquals(c2.getPassword(), "222");

    }
}