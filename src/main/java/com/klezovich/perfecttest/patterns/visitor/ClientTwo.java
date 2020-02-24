package com.klezovich.perfecttest.patterns.visitor;

public class ClientTwo extends Client {

    public void accept(ConfigurationVisitor v) {
        v.visit(this);
    }
}
