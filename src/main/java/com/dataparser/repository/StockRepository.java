package com.dataparser.repository;

import com.dataparser.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAllByStock(String stock);

    List<Stock> findAllByStockAndQuarter(String stock, String quarter);
}
