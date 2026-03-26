package com.maintenanceAdjoka.app.backend;

import com.maintenanceAdjoka.app.backend.models.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    // CREATE
    public static void save(Client c) throws Exception {
        String sql = "INSERT INTO clients (name, phone, address) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getPhoneNumber());
            pstmt.setString(3, c.getAddress());
            pstmt.setInt(4, c.getSeasonPrice());
            pstmt.executeUpdate();
        }
    }

    // READ ALL
    //
    // add les truc pour le season price et reamining debt
    public static List<Client> findAll() throws Exception {
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clients.add(new Client(
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getInt("seasonPrice")
                ));
            }
        }
        return clients;
    }

    // FIND BY NAME
    public static List<Client> getClientByName(String name) throws Exception {
        String sql = "SELECT * FROM clients WHERE name LIKE ?";
        List<Client> clients = new ArrayList<>();
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    clients.add(new Client(
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("seasonPrice")
                    ));
                }
            }
        }
        return clients;
    }

    // DELETE
    public static void delete(int id) throws Exception {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
