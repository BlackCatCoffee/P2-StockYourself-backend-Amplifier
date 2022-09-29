package com.revature.stockYourself.beans;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.stereotype.Component;
import yahoofinance.histquotes.HistoricalQuote;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StockData {
	private String name;
	private BigDecimal price;
	private BigDecimal peg;
	private BigDecimal change;
	private String currency;
	private List<HistoricalQuote> stockQuotes;
}
