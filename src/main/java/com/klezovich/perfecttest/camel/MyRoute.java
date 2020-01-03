package com.klezovich.perfecttest.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/Users/aklezovics/in?noop=true")
            .to("file:/Users/aklezovics/out");
    }
}
