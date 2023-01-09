package models;

import java.sql.Connection;

public class DataService {
    Database database;
    public DataService(Database database) {
        this.database = database;
        Connection con = this.database.connect();
    }
}
