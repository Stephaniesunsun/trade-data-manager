package com.harrisburg.trade_manager.controller;

import com.harrisburg.trade_manager.model.Trade;
import com.harrisburg.trade_manager.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id).orElseThrow(() -> new RuntimeException("Trade not found"));
    }
}
