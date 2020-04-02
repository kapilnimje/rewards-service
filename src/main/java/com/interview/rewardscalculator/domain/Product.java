package com.interview.rewardscalculator.domain;

import java.util.Objects;

public class Product {

  private static long serialVersionId = -1L;

  private String name;
  private String type;
  private double price;

  public Product(String name, String type, double price) {
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Double.compare(product.price, price) == 0
        && name.equals(product.name)
        && type.equals(product.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, price);
  }

  @Override
  public String toString() {
    return "Product{"
        + "name='"
        + name
        + '\''
        + ", type='"
        + type
        + '\''
        + ", price="
        + price
        + '}';
  }
}
