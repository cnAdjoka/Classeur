package com.maintenanceAdjoka.app.backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DatabaseManager{

  private static final String URL = "jdbc:sqlite:clients.db";

  public static Connection connect() throws Exception {
    return DriverManager.getConnection(URL);
  }


  //creates the connection and a table for the clients
  public static void init() throws Exception {
    String sql = """
            CREATE TABLE IF NOT EXISTS clients (
                id      INTEGER PRIMARY KEY AUTOINCREMENT,
                name    TEXT NOT NULL,
                phone   TEXT,
                address TEXT,
                town TEXT,
                seasonPrice INTEGER,
                remainingDebt INTEGER

            )
            """;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }


}



