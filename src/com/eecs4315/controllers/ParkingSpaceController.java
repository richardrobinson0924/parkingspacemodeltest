package com.eecs4315.controllers;

import com.eecs4315.databases.ParkingSpaceDatabase;
import com.eecs4315.models.ParkingSpace;

import java.util.Collection;

public class ParkingSpaceController {
    private static ParkingSpaceController instance = null;

    private ParkingSpaceController() {
    }

    public static ParkingSpaceController getInstance() {
        if (instance == null) {
            instance = new ParkingSpaceController();
        }

        return instance;
    }

    public Collection<ParkingSpace> getAllSpaces() {
        return ParkingSpaceDatabase.getInstance().find(null);
    }

    public void addSpace() {
        ParkingSpaceDatabase.getInstance().insert(new ParkingSpace());
    }

    public void removeSpace(long id) {
        var space = ParkingSpaceDatabase.getInstance().findById(id).orElseThrow();
        if (space.getStatus() == ParkingSpace.Status.Occupied) {
            return;
        }

        ParkingSpaceDatabase.getInstance().remove(id);
    }
}