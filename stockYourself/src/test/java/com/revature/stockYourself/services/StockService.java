package com.revature.stockYourself.services;

import com.revature.stockYourself.StockYourselfApplication;
import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.data.StockStringRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@SpringBootTest(classes= StockYourselfApplication.class)
public class StockService {
    @MockBean
    private StockStringRepository repository;



    @Autowired
    private StockDataService stockService;

    @Test
    public void getStockByString() throws IOException {
        String stockString = "AAPL";
        Stock stock = YahooFinance.get(stockString);
        when(repository.findByStockString(stockString)).thenReturn(stock);
        StockData stockData = new StockData(
                stock.getName(),
                stock.getQuote().getPrice(),
                stock.getStats().getPeg(),
                stock.getQuote().getChange(),
                stock.getCurrency(),
                stock.getHistory()
        );
        StockData actualStock = stockService.getStockDataBySymbol(stockString);
        assertEquals(stockData,actualStock);

    }
}
