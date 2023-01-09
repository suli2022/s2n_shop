package models;

import java.sql.Connection;

public interface Database {
    public Connection connect();
    public void close(Connection con);
}
