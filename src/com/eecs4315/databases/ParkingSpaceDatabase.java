package com.eecs4315.databases;

import com.eecs4315.models.ParkingSpace;

public class ParkingSpaceDatabase extends Database<Long, ParkingSpace> {
    private static ParkingSpaceDatabase instance = null;

    public static ParkingSpaceDatabase getInstance() {
        if (instance == null) {
            instance = new ParkingSpaceDatabase();
        }

        return instance;
    }
}
