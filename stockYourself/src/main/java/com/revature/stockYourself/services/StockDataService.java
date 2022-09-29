package com.revature.stockYourself.services;

import com.revature.stockYourself.beans.StockData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface StockDataService {
    public StockData getStockDataBySymbol(String stockString) throws IOException;
    public List<StockData> getStockDataList(List<String> stockSymbols) throws IOException;
}
