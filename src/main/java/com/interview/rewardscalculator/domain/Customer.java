package com.interview.rewardscalculator.domain;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

  private static long serialVersionId = -1L;

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String emailID;

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailID() {
    return emailID;
  }

  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return firstName.equals(customer.firstName)
        && lastName.equals(customer.lastName)
        && phoneNumber.equals(customer.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, phoneNumber, emailID);
  }

  @Override
  public String toString() {
    return "Customer{"
        + "firstName='"
        + firstName
        + '\''
        + ", LastName='"
        + lastName
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", emailID='"
        + emailID
        + '\''
        + '}';
  }
}
