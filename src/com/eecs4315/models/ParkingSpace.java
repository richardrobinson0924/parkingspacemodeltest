package com.eecs4315.models;

import com.eecs4315.Identifiable;

public class ParkingSpace implements Identifiable<Long> {
    public enum Status {
        Empty, Occupied
    }

    private final long id;
    private Status status;

    public ParkingSpace() {
        this.id = 0L;
        this.status = Status.Empty;
    }

    @Override
    public Long getId() {
        return null;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
