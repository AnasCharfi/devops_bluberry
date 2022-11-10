package tn.esprit.rh.achat.services;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.entities.Stock;

import java.util.List;

@Component
public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	String retrieveStatusStock();
}
