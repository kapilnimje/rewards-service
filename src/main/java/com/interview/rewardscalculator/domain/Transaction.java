package com.interview.rewardscalculator.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction implements Serializable {

  private static long serialVersionId = -1L;

  private Customer customer;
  private Product product;
  private LocalDate transactionDate;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return customer.equals(that.customer)
        && product.equals(that.product)
        && transactionDate.equals(that.transactionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, product, transactionDate);
  }

  @Override
  public String toString() {
    return "Transaction{"
        + "customer="
        + customer
        + ", product="
        + product
        + ", transactionDate="
        + transactionDate
        + '}';
  }
}
