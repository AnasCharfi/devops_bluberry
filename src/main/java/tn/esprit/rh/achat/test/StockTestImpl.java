package tn.esprit.rh.achat.test;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class StockTestImpl {

    @Autowired
    IStockService stockService;

    @Test
    public  void testAddStock(){
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        int x= expected+1 ;
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock savedStock= stockService.addStock(s);
        assertEquals(x, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());

    }

    @Test
    public  void testUpdateStock()  {
        List<Stock> stocks = stockService.retrieveAllStocks();
        if (stocks.isEmpty())
        {
            log.info("Fct test update stock : Stock Vide");
            return ;
        }
        Stock old= stocks.get(0) ;
        Stock s = new Stock();
        s.setIdStock(old.getIdStock());
        s.setLibelleStock("stock updated");
        s.setQte(20);
        s.setQteMin(200);
        Stock savedStock= stockService.updateStock(s);
        assertNotEquals(savedStock,old);
        assertNotNull(savedStock.getLibelleStock());
        stockService.updateStock(old);
    }


    @Test
    public void testDeleteStock() {

        List<Stock> stocks = stockService.retrieveAllStocks();
        if(stocks.isEmpty())
        {
            log.info("Fct test Delete stock : Stock Vide");
            return ;
        }
        int expected=stocks.size();
        int x= expected-1 ;
        Stock s = stocks.get(0);
        stockService.deleteStock(s.getIdStock());
        assertEquals(x, stockService.retrieveAllStocks().size());
    }


    @Test
    public void testRetreiveStatusStock() {

        List<Stock> stocks = stockService.retrieveAllStocks();
        if(stocks.isEmpty())
        {
            log.info("Fct test Delete stock : Stock Vide");
          
        }else {
            log.info(stockService.retrieveStatusStock());
        }
    }
}
