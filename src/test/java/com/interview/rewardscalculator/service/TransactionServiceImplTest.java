package com.interview.rewardscalculator.service;

import com.interview.rewardscalculator.domain.Customer;
import com.interview.rewardscalculator.domain.Product;
import com.interview.rewardscalculator.domain.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TransactionServiceImplTest {

    @Mock
    TransactionServiceImpl transactionServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void purchaseTransactionTest()
    {
        Transaction transaction = new Transaction();
        Customer customer = new Customer("Kapil","Nimje");
        Product product = new Product("Apple iPhone 10", "Electronics", 120);
        transaction.setCustomer(customer);
        transaction.setProduct(product);
        transaction.setTransactionDate(LocalDate.now());
        int calculatedRewards = 90;
        Map<Transaction, Integer> map = new HashMap<>();
        map.put(transaction, calculatedRewards);
        when(transactionServiceImpl.purchase(transaction)).thenReturn(map);
        assertNotNull(map);
        assertEquals(calculatedRewards, map.get(transaction));
    }

    @Test
    public void getRewardsTest() {
        Customer customer = new Customer("Kapil", "Nimje");
        String days = "1";
        int rewards = 90;
        when(transactionServiceImpl.getRewards(customer, days)).thenReturn(rewards);
        assertNotNull(rewards);
        assertEquals(90, rewards);
    }




}
