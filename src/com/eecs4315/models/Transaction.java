package com.eecs4315.models;

import com.eecs4315.Identifiable;

public class Transaction implements Identifiable<Long> {
    private final long id;
    private final long customerId;
    private final long parkingSpaceId;
    private final String bankNumber;

    public Transaction(long customerId, long parkingSpaceId, String bankNumber) {
        this.customerId = customerId;
        this.parkingSpaceId = parkingSpaceId;
        this.id = 0L;
        this.bankNumber = bankNumber;
    }

    @Override
    public Long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public String getBankNumber() {
        return bankNumber;
    }
}
