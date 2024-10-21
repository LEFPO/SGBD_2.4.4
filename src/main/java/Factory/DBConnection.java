package main.java.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://127.0.0.1/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Arkana10021994";

    // Connexion à une base de données spécifique
    public static Connection connect(String dbName) throws SQLException {
        String connectionUrl = URL + dbName;
        return DriverManager.getConnection(connectionUrl, USER, PASSWORD);
    }

    // Création de la base de données si elle n'existe pas
    public static void createDatabase(String dbName) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             var stmt = conn.createStatement()) {

            // Vérifier si la base de données existe déjà
            String checkDbExistsQuery = "SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'";
            var rs = stmt.executeQuery(checkDbExistsQuery);

            if (rs.next()) {
                System.out.println("La base de données " + dbName + " existe déjà.");
            } else {
                String sql = "CREATE DATABASE " + dbName;
                stmt.executeUpdate(sql);
                System.out.println("Base de données " + dbName + " créée avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la base de données : " + e.getMessage());
        }
    }
}
