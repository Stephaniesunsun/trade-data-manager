package com.harrisburg.trade_manager.config;

import com.harrisburg.trade_manager.model.Trade;
import com.harrisburg.trade_manager.service.TradeService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CamelConfig extends RouteBuilder {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void configure() throws Exception {
        System.out.println("start reading files");
        Resource resource = resourceLoader.getResource("file:input/trades");
        try {
            System.out.println("Input directory path: " + resource.getURI());
        } catch (Exception e) {
            System.err.println("Error resolving input directory path: " + e.getMessage());
        }

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
        jaxbDataFormat.setContextPath(Trade.class.getPackage().getName());

        from("file:input/trades?noop=true")
                .log("Received file: ${header.CamelFileName}")
                .unmarshal(jaxbDataFormat)
                .process(exchange -> {
                    Trade trade = exchange.getIn().getBody(Trade.class);
                    tradeService.saveTrade(trade);
                })
                .log("Trade saved: ${body}");
    }
}
