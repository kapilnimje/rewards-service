package com.interview.rewardscalculator.dto;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseResponseDTO implements Serializable {
    private static long serialVersionId = -1L;

    private String message;
    private int rewardsEarned;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRewardsEarned() {
        return rewardsEarned;
    }

    public void setRewardsEarned(int rewardsEarned) {
        this.rewardsEarned = rewardsEarned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseResponseDTO that = (PurchaseResponseDTO) o;
        return rewardsEarned == that.rewardsEarned &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, rewardsEarned);
    }

    @Override
    public String toString() {
        return "PurchaseResponseDTO{" +
                "message='" + message + '\'' +
                ", rewardsEarned=" + rewardsEarned +
                '}';
    }
}
