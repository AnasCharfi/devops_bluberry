package tn.esprit.rh.achat.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.annotation.JsonFormat;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class stockTestImpl {

    @Autowired
    IStockService stockService;

    @Test
    public  void testAddStock(){
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock savedStock= stockService.addStock(s);
        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());
    }

    @Test
    public  void testUpdateStock()  throws Exception {
        List<Stock> stocks = stockService.retrieveAllStocks();
        if (stocks.isEmpty())
        {
            System.out.println("Fct test update stock : Stock Vide");
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
            System.out.println("Fct test Delete stock : Stock Vide");
            return ;
        }
        int expected=stocks.size();
        Stock s = stockService.retrieveStock((long)22);
        stockService.deleteStock(s.getIdStock());
        assertEquals(expected-1, stockService.retrieveAllStocks().size());
    }
}
