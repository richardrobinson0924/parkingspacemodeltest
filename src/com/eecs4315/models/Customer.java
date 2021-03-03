package com.eecs4315.models;

import com.eecs4315.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer implements Identifiable<Long> {
    private final long id;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String password;
    private final Map<Long, ParkingSpaceBooking> bookings;

    private boolean isAuthenticated;

    public Customer(String firstName, String lastName, String emailAddress, String password) {
        this.id = 0L;

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.bookings = new HashMap<>();

        this.isAuthenticated = false;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticationStatus(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public void addBooking(ParkingSpaceBooking booking) {
        this.bookings.put(booking.getId(), booking);
    }

    public Map<Long, ParkingSpaceBooking> getBookings() {
        return bookings;
    }
}
