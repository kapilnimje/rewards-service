package com.interview.rewardscalculator.rest;

import com.interview.rewardscalculator.domain.Customer;
import com.interview.rewardscalculator.domain.Transaction;
import com.interview.rewardscalculator.dto.PurchaseResponseDTO;
import com.interview.rewardscalculator.dto.RewardsSearchResponseDTO;
import com.interview.rewardscalculator.dto.TransactionResponseDTO;
import com.interview.rewardscalculator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RewardsController {

  @Autowired private TransactionService transactionService;
  private static final String MESSAGE = "Item Purchased Successfully";

  @PostMapping("/purchase")
  public ResponseEntity<PurchaseResponseDTO> purchaseProduct(@RequestBody Transaction transaction) {
    Map<Transaction, Integer> rewards = transactionService.purchase(transaction);
    PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
    purchaseResponseDTO.setMessage(MESSAGE);
    purchaseResponseDTO.setRewardsEarned(rewards.get(transaction));
    return new ResponseEntity<>(purchaseResponseDTO, HttpStatus.OK);
  }

  @GetMapping("/rewards/search")
  public ResponseEntity<RewardsSearchResponseDTO> getRewardsPerCustomer(
      @RequestParam("firstName") String customerFname,
      @RequestParam("lastName") String customerLname,
      @RequestParam("filterDays") String days) {
    Customer customer = new Customer(customerFname, customerLname);
    int totalRewards = transactionService.getRewards(customer, days);
    RewardsSearchResponseDTO rewardsSearchResponseDTO = new RewardsSearchResponseDTO();
    rewardsSearchResponseDTO.setFirstName(customerFname);
    rewardsSearchResponseDTO.setLastName(customerLname);
    rewardsSearchResponseDTO.setTotalRewards(totalRewards);
    return new ResponseEntity<>(rewardsSearchResponseDTO, HttpStatus.OK);
  }

  @GetMapping("/rewards/transaction")
  public ResponseEntity<List<TransactionResponseDTO>> getAllRewards() {

    List<TransactionResponseDTO> transactionList =
        transactionService.getTotalTransactionRewards().entrySet().stream()
            .map(
                s -> {
                  TransactionResponseDTO responseDTO = new TransactionResponseDTO();
                  responseDTO.setCustomerName(
                      s.getKey().getCustomer().getFirstName()
                          + " "
                          + s.getKey().getCustomer().getLastName());
                  responseDTO.setProductName(s.getKey().getProduct().getName());
                  responseDTO.setProductPrice(s.getKey().getProduct().getPrice());
                  responseDTO.setPurchaseDate(s.getKey().getTransactionDate());
                  responseDTO.setRewardsEarned(s.getValue());
                  return responseDTO;
                })
            .collect(Collectors.toList());

    return new ResponseEntity<>(transactionList, HttpStatus.OK);
  }
}
