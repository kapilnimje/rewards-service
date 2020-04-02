package com.interview.rewardscalculator.service;

import com.interview.rewardscalculator.domain.Customer;
import com.interview.rewardscalculator.domain.Transaction;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

  private static Map<Transaction, Integer> rewardsMap = new HashMap<>();

  @Override
  public Map<Transaction, Integer> purchase(Transaction transaction) {
    LocalDate now = LocalDate.now();
    transaction.setCustomer(transaction.getCustomer());
    transaction.setProduct(transaction.getProduct());
    transaction.setTransactionDate(now);
    return calculateRewards(transaction);
  }

  private Map<Transaction, Integer> calculateRewards(Transaction transaction) {
    int rewards = 0, totalRewards = 0;
    if (Objects.nonNull(transaction)) {
      double price = transaction.getProduct().getPrice();
      // If product price is above $50 but less than $100, then customer will get 1 rewards point
      // over $50
      if (price > 50 && price < 100) {
        double priceDiff = price - 50;
        rewards = (int) (priceDiff);
      }

      // If product price is above $100, then customer will get 2 rewards points over $100 spent +
      // 50 additional points (since they spent more than $50)
      if (price > 100) {
        double priceDiff = price - 100;
        rewards = (int) (2 * priceDiff) + (50);
      }

      totalRewards += rewards;
    }
    rewardsMap.put(transaction, totalRewards);
    return rewardsMap;
  }

  @Override
  public Integer getRewards(Customer customer, String days) {
    int totalRewards = 0;

    String customerFname = customer.getFirstName();
    String customerLname = customer.getLastName();

    if (Strings.isNotBlank(customerFname)
        && Strings.isNotBlank(customerLname)
        && Strings.isNotBlank(days)) {

      LocalDate date = LocalDate.now();
      LocalDate dateMinusDays = date.minusDays(Integer.parseInt(days));

      for (Map.Entry<Transaction, Integer> entry : rewardsMap.entrySet()) {
        if (entry.getKey().getCustomer().getFirstName().equalsIgnoreCase(customerFname)
            && entry.getKey().getCustomer().getLastName().equalsIgnoreCase(customerLname)
            && entry.getKey().getTransactionDate().isAfter(dateMinusDays) && entry.getKey().getTransactionDate().isBefore(dateMinusDays))
          totalRewards += entry.getValue();
      }
    }

    if (Strings.isNotBlank(customerFname) && Strings.isNotBlank(customerLname)) {
      for (Map.Entry<Transaction, Integer> entry : rewardsMap.entrySet()) {
        if (entry.getKey().getCustomer().getFirstName().equalsIgnoreCase(customerFname)
            && entry.getKey().getCustomer().getLastName().equalsIgnoreCase(customerLname))
          totalRewards += entry.getValue();
      }
    }
    return totalRewards;
  }

  @Override
  public Map<Transaction, Integer> getTotalTransactionRewards() {
    return rewardsMap;
  }
}
