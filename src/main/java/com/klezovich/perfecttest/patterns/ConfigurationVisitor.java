package com.klezovich.perfecttest.patterns;

public class ConfigurationVisitor {

    public void visit(ClientOne c) {
        c.setPassword("111");
        c.setUserName("User1");
    }

    public void visit(ClientTwo c) {
        c.setPassword("222");
        c.setUserName("User2");
    }
}
