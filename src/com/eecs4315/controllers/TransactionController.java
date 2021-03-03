package com.eecs4315.controllers;

import com.eecs4315.databases.TransactionDatabase;
import com.eecs4315.models.Transaction;

public class TransactionController {
    private static TransactionController instance = null;

    private TransactionController() {
    }

    public static TransactionController getInstance() {
        if (instance == null) {
            instance = new TransactionController();
        }

        return instance;
    }

    public void pay(long customerId, long parkingSpaceId, String bankNumber) {
        var transaction = new Transaction(customerId, parkingSpaceId, bankNumber);
        TransactionDatabase.getInstance().insert(transaction);
    }
}
