package com.klezovich.perfecttest.tech.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;

//@Component
public class ConsoleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("stream:in")
            .process(new UppercaseProcessor())
            .loop(3)
            .to("stream:out");
    }

    static class PairAggregationStrategy implements AggregationStrategy {

        @Override
        public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            if (oldExchange == null) {
                return newExchange;
            }

            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = newExchange.getIn().getBody(String.class);
            oldExchange.getIn().setBody(oldBody + "+" + newBody);
            return oldExchange;
        }
    }

    static class UppercaseProcessor implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
            String payload = exchange.getIn().getBody(String.class);
            exchange.getIn().setBody(payload.toUpperCase());
        }
    }
}
