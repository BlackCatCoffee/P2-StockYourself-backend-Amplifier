package com.revature.stockYourself.services;

import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.data.StockStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockDataServiceImpl implements StockDataService{


    private StockStringRepository stock;

    @Autowired
    public StockDataServiceImpl(StockStringRepository stock){
        this.stock = stock;
    }
    @Override
    public StockData getStockDataBySymbol(String stockString) throws IOException {
        Optional<Stock> stock1 = Optional.ofNullable(stock.findByStockString(stockString));
        if (stock1.isPresent()) {
            return new StockData(
                    stock1.get().getName(),
                    stock1.get().getQuote().getPrice(),
                    stock1.get().getStats().getPeg(),
                    stock1.get().getQuote().getChange(),
                    stock1.get().getCurrency(),
                    stock1.get().getHistory()
            );
        }else return null;
    }

    @Override
    public List<StockData> getStockDataList(List<String> stockSymbols) throws IOException {
        List<StockData> stockData = new ArrayList<>();
        for(String stockString:stockSymbols){
            stockData.add(getStockDataBySymbol(stockString));
        }
        return stockData;
    }
}
