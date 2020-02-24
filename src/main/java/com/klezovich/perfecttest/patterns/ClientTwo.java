package com.klezovich.perfecttest.patterns;

public class ClientTwo extends Client {

    public void accept(ConfigurationVisitor v) {
        v.visit(this);
    }
}
