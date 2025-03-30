package com.harrisburg.trade_manager.service;

import com.harrisburg.trade_manager.model.Trade;
import com.harrisburg.trade_manager.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Trade saveTrade(Trade trade) {
        return tradeRepository.save(trade);
    }
}
