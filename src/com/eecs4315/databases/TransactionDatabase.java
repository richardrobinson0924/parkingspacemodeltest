package com.eecs4315.databases;

import com.eecs4315.models.Transaction;

public class TransactionDatabase extends Database<Long, Transaction> {
    private static TransactionDatabase instance = null;

    public static TransactionDatabase getInstance() {
        if (instance == null) {
            instance = new TransactionDatabase();
        }

        return instance;
    }
}
