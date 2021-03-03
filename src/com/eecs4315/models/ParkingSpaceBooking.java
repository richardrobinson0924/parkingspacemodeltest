package com.eecs4315.models;

import java.util.Date;

public class ParkingSpaceBooking {
    private final long parkingSpaceId;
    private final long id;
    private final String plate;
    private final Date expirationDate;

    public ParkingSpaceBooking(long parkingSpaceId, String plate, Date expirationDate) {
        this.id = 0L;
        this.parkingSpaceId = parkingSpaceId;
        this.plate = plate;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public String getPlate() {
        return plate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
