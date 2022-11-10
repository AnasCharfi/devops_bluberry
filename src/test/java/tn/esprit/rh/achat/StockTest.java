package tn.esprit.rh.achat;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.context.support.AnnotationConfigContextLoader;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest//(classes=StockTest.class)
@RunWith(SpringRunner.class)
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ContextConfiguration( loader= AnnotationConfigContextLoader.class)
public class StockTest {

    @Autowired
    IStockService stockService;
/*
    @Test
    @Order(1)
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
       //stockService.deleteStock(savedStock.getIdStock());
    }

    @Test
    @Order(1)
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
    @Order(6)
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
    @Order(3)
    public void testRetreiveStock() {
        Stock s1 =stockService.retrieveStock((long)42);
        assertEquals("stock test",s1.getLibelleStock() );
        assertEquals(10, s1.getQte().intValue() );
        assertEquals(100, s1.getQteMin().intValue() );
    }


    @Test
    @Order(4)
    public void testRetreiveStatusStock() {

        List<Stock> stocks = stockService.retrieveAllStocks();
        if(stocks.isEmpty())
        {
            log.info("Fct test Delete stock : Stock Vide");

        }else {
            int x = stocks.size();
            Stock s = new Stock();
            s.setLibelleStock("stock test");
            s.setQte(10);
            s.setQteMin(100);
            Stock savedStock= stockService.addStock(s);
            assertEquals(x+1, stockService.retrieveAllStocks().size());
        }
    }
    @Test
    @Order(5)
    public void testRetreiveAllStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        assertNotNull(stocks.size());
    }

    */

}
