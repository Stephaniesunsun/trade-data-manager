package com.harrisburg.trade_manager.repository;

import com.harrisburg.trade_manager.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
