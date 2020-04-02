package com.interview.rewardscalculator.service;

import com.interview.rewardscalculator.domain.Customer;
import com.interview.rewardscalculator.domain.Transaction;

import java.util.Map;

public interface TransactionService {

  Map<Transaction, Integer> purchase(Transaction transaction);

  Integer getRewards(Customer customer, String days);

  Map<Transaction, Integer> getTotalTransactionRewards();
}
