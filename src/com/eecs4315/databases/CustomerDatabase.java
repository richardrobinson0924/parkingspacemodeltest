package com.eecs4315.databases;

import com.eecs4315.models.Customer;

public class CustomerDatabase extends Database<Long, Customer> {
    private static CustomerDatabase instance = null;

    public static CustomerDatabase getInstance() {
        if (instance == null) {
            instance = new CustomerDatabase();
        }

        return instance;
    }
}
