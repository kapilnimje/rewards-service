package com.interview.rewardscalculator.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TransactionResponseDTO implements Serializable {

  private static long serialVersionId = -1L;

  private String customerName;
  private String productName;
  private double productPrice;
  private LocalDate purchaseDate;
  private int rewardsEarned;

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public int getRewardsEarned() {
    return rewardsEarned;
  }

  public void setRewardsEarned(int rewardsEarned) {
    this.rewardsEarned = rewardsEarned;
  }

  @Override
  public String toString() {
    return "TransactionResponseDTO{"
        + "customerName='"
        + customerName
        + '\''
        + ", productName='"
        + productName
        + '\''
        + ", productPrice="
        + productPrice
        + ", purchaseDate="
        + purchaseDate
        + ", rewardsEarned="
        + rewardsEarned
        + '}';
  }
}
