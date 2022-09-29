package com.revature.stockYourself.beans;


import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

//import org.springframework.data.annotation.Id;


@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;
	@Column
	private String portfolioName;


	//private List<String> portfolioStringStocks;


}









