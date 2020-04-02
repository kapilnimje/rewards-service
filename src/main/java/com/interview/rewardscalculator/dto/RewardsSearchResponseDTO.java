package com.interview.rewardscalculator.dto;

import java.io.Serializable;

public class RewardsSearchResponseDTO implements Serializable {

  private static final long serialVersionID = -1L;

  private String firstName;
  private String lastName;
  private int totalRewards;

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
    this.lastName = lastName;
  }

  public int getTotalRewards() {
    return totalRewards;
  }

  public void setTotalRewards(int totalRewards) {
    this.totalRewards = totalRewards;
  }

  @Override
  public String toString() {
    return "RewardsSearchResponseDTO{"
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", totalRewards="
        + totalRewards
        + '}';
  }
}
