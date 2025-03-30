package com.harrisburg.trade_manager.service;

import com.harrisburg.trade_manager.model.Trade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    private final List<Trade> trades = new ArrayList<>();
    private long nextId = 1;

    public List<Trade> getAllTrades() {
        return trades;
    }

    public Optional<Trade> getTradeById(Long id) {
        return trades.stream()
                .filter(trade -> trade.getId().equals(id))
                .findFirst();
    }

    public Trade saveTrade(Trade trade) {
        trade.setId(nextId++); // Assign a unique ID
        trades.add(trade); // Add to the in-memory list
        return trade;
    }
}