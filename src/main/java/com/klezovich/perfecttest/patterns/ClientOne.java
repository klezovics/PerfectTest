package com.klezovich.perfecttest.patterns;

public class ClientOne extends Client {

    public void accept(ConfigurationVisitor v) {
        v.visit(this);
    }
}
