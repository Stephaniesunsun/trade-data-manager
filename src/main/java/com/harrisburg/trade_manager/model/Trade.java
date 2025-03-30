package com.harrisburg.trade_manager.model;

import jakarta.persistence.*;
import lombok.Data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Data
@Entity
@XmlRootElement(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String securityId;

    private String clientName;

    private String timestamp;

    private double quantity;

    private double price;
}
