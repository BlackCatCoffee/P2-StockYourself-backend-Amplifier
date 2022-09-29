package com.revature.stockYourself.controllers;

import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.services.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
    private static StockDataService stockDataService;

    @Autowired
    public StockController(StockDataService stockDataService){
        StockController.stockDataService = stockDataService;
    }

    @GetMapping(path = "/{stockSymbol}")
    public ResponseEntity<StockData> getStock(@PathVariable String stockSymbol) throws IOException {
        StockData stockData = stockDataService.getStockDataBySymbol(stockSymbol);
        if(stockData!=null){
            return ResponseEntity.ok(stockData);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
