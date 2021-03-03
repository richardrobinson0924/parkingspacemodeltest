package com.eecs4315.models;

import com.eecs4315.Identifiable;

public class Officer implements Identifiable<Long> {
    private final long id;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public Officer(String firstName, String lastName, String emailAddress) {
        this.id = 0L;

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    @Override
    public Long getId() {
        return id;
    }
}
