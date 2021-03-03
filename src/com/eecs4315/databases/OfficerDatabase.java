package com.eecs4315.databases;

import com.eecs4315.models.Officer;

public class OfficerDatabase extends Database<Long, Officer> {
    private static OfficerDatabase instance = null;

    public static OfficerDatabase getInstance() {
        if (instance == null) {
            instance = new OfficerDatabase();
        }

        return instance;
    }
}
