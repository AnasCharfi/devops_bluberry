package tn.esprit.rh.achat.controllers;
import org.modelmapper.ModelMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.StockModel;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {


	@Autowired
	IStockService stockService;


	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();

	}


	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}


	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody StockModel s) {

		return stockService.addStock(new Stock(s));

	}


	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}


	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody StockModel stock) {
		ModelMapper modelMapper= new ModelMapper() ;
		Stock postRequest = modelMapper.map(stock, Stock.class);
		return stockService.updateStock(postRequest);
	}


}