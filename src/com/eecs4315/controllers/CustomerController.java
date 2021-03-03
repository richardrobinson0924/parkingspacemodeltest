package com.eecs4315.controllers;

import com.eecs4315.databases.CustomerDatabase;
import com.eecs4315.databases.ParkingSpaceDatabase;
import com.eecs4315.models.Customer;
import com.eecs4315.models.ParkingSpace;
import com.eecs4315.models.ParkingSpaceBooking;

import java.util.Date;

public class CustomerController {
    private static CustomerController instance = null;

    private CustomerController() {
    }

    public static CustomerController getInstance() {
        if (instance == null) {
            instance = new CustomerController();
        }

        return instance;
    }

    void registerUser(String firstName, String lastName, String email, String password) {
        CustomerDatabase.getInstance().insert(new Customer(firstName, lastName, email, password));
    }

    void authenticate(String email, String password) {
        CustomerDatabase.getInstance()
                .findOne(c -> c.getEmailAddress().equals(email) && c.getPassword().equals(password))
                .ifPresent(c -> c.setAuthenticationStatus(true));
    }

    long bookParkingSpace(long customerId, long parkingSpaceId, Date expirationDate, String plate) {
        var parkingSpace = ParkingSpaceDatabase.getInstance().findById(parkingSpaceId).orElseThrow();

        if (parkingSpace.getStatus() == ParkingSpace.Status.Occupied) {
            throw new IllegalStateException("Parking space is occupied");
        }

        var customer = CustomerDatabase.getInstance().findById(customerId).orElseThrow();

        if (customer.getBookings().size() >= 3) {
            throw new IllegalArgumentException("Cannot book more than 3 spaces");
        }
        if (!customer.isAuthenticated()) {
            throw new IllegalArgumentException("Customer is not authenticated");
        }

        parkingSpace.setStatus(ParkingSpace.Status.Occupied);

        var booking = new ParkingSpaceBooking(parkingSpaceId, plate, expirationDate);
        customer.addBooking(booking);

        return booking.getId();
    }

    void cancelBooking(long bookingId, long customerId) {
        var customer = CustomerDatabase.getInstance().findById(customerId).orElseThrow();

        if (!customer.isAuthenticated()) {
            throw new IllegalArgumentException("Customer is not authenticated");
        }

        var booking = customer.getBookings().get(bookingId);
        if (booking == null) {
            throw new IllegalArgumentException("Booking id invalid");
        }

        if (new Date().after(booking.getExpirationDate())) {
            return;
        }

        var spaceId = booking.getParkingSpaceId();
        var space = ParkingSpaceDatabase.getInstance().findById(spaceId).orElseThrow();
        space.setStatus(ParkingSpace.Status.Empty);
    }
}
