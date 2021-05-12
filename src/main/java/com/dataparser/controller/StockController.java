package com.dataparser.controller;

import com.dataparser.entity.Stock;
import com.dataparser.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/uploadStock")
    public String uploadStocks(@RequestParam("file") MultipartFile file) {
        BufferedReader br;
        List<Stock> result = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            br.readLine();// ignore first line as its header
            while ((line = br.readLine()) != null) {
                Stock stock = new Stock(line.split(","));
                result.add(stock);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        stockRepository.saveAll(result);
        System.out.println(result.size() + " Records inserted in the database");
        return result.size() + " Records inserted in the database";
    }

    @PostMapping("/addNewStock")
    public String addNewStock(@RequestBody Stock newStock) {
        stockRepository.save(newStock);
        System.out.println("New Stock saved successfully with Id " + newStock.getId());
        return "New Stock saved successfully with Id " + newStock.getId();
    }

    @GetMapping("/query")
    public List<Stock> queryStock(String ticker) {
        List<Stock> queryResult = stockRepository.findAllByStock(ticker);
        System.out.println(queryResult.size() + " records found");
        return queryResult;
    }

    @GetMapping("/queryByQuarter")
    public List<Stock> queryStockByQuarter(String ticker, String quarter) {
        List<Stock> queryResult = stockRepository.findAllByStockAndQuarter(ticker, quarter);
        System.out.println(queryResult.size() + " records found");
        return queryResult;
    }

}
