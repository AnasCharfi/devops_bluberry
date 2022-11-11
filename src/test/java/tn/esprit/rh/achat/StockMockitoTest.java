package tn.esprit.rh.achat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@Slf4j
public class StockMockitoTest {

    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;

    Stock s = new Stock("test stock",10, 1);
    ArrayList<Stock> listeStock = new ArrayList<Stock>(){{
        add(new Stock("test stock2",20, 2));
        add(new Stock("test stock3",30, 3));
        add(new Stock("test stock4",30, 4));
    }};

    @Test
    public void addStockTest()
    {
        s.setIdStock((long)1);
        when(stockRepository.save(s)).thenReturn(s);
        Stock savedStock = stockService.addStock(s);
        assertNotNull(savedStock.getLibelleStock());
    }


    @Test
    public void updateStockTest()
    {
        this.addStockTest();
        log.info("stock before update : " + s);
        s.setQteMin(2);
        Stock savedStock = stockService.updateStock(s);
        log.info("stock after update : " + savedStock);
        assertNotNull(savedStock);
        assertEquals(2, savedStock.getQteMin().intValue() );
    }

    @Test
    public void deleteStockTest()
    {   s.setIdStock((long)1);
        log.info("stock before delete : " );
        stockService.deleteStock(s.getIdStock()) ;
        log.info("stock after update : ");
        verify(stockRepository).deleteById(anyLong());
    }

    @Test
    public void retrieveStockTest()
    {
        s.setIdStock((long)1);
        when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock s1 =stockService.retrieveStock(s.getIdStock());
        assertNotNull(s1);
        assertEquals("test stock",s1.getLibelleStock() );
        assertEquals(10, s1.getQte().intValue() );
        assertEquals(1, s1.getQteMin().intValue() );

    }

    @Test
    public void RetrieveAllStockTest()
    {
        listeStock.get(0).setIdStock((long)2);
        listeStock.get(1).setIdStock((long)3);
        listeStock.get(2).setIdStock((long)4);
        when(stockRepository.findAll()).thenReturn(listeStock);
        List<Stock> stocks = stockService.retrieveAllStocks();
        assertEquals(listeStock.size(), stocks.size());
        verify(stockRepository, times(1)).findAll();
    }

    @Test
    public void retrieveStatusStockTest(){
        listeStock.get(0).setIdStock((long)2);
        listeStock.get(1).setIdStock((long)3);
        listeStock.get(2).setIdStock((long)4);
        when(stockRepository.retrieveStatusStock()).thenReturn(listeStock);
        String stocks = stockService.retrieveStatusStock();
        assertNotNull(stocks);
    }

}
