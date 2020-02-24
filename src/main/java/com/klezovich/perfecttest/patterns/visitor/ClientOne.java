package com.klezovich.perfecttest.patterns.visitor;

public class ClientOne extends Client {

    public void accept(ConfigurationVisitor v) {
        v.visit(this);
    }
}
