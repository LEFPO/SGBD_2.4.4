import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connexion {
    public static void main(String[] args) throws Exception {
        // Informations de connexion
        final String url = "jdbc:postgresql://127.0.0.1/";
        final String user = "postgres";
        final String password = "Arkana10021994";

        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connexion à la base de données
            connexion = DriverManager.getConnection(url, user, password);
            System.out.println("Connecté à la base de données : " + url);

            // Création de la base de données "ecole"
            statement = connexion.createStatement();
            String requeteSQL = "CREATE DATABASE ecole";
            statement.executeUpdate(requeteSQL);

            // Connexion à la nouvelle base de données "ecole"
            connexion = DriverManager.getConnection(url + "ecole", user, password);

            // Création d'un nouveau statement pour la nouvelle connexion
            statement = connexion.createStatement();

            try {
                // Création des tables Section et Cours
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS Section (id SERIAL PRIMARY KEY, NOM VARCHAR(30));");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS Cours (id SERIAL PRIMARY KEY, id_section INT, NOM VARCHAR(30), CONSTRAINT fk_id_section FOREIGN KEY (id_section) REFERENCES Section(id));");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la création des tables : " + e.getMessage());
            }

            try {
                // Insertion des données dans les tables
                statement.executeUpdate("INSERT INTO Section (NOM) VALUES ('Informatique de Gestion'), ('Droit');");
                statement.executeUpdate("INSERT INTO Cours (id_section, NOM) VALUES (1, 'Base des réseaux'), (1, 'Système d''exploitation'), (1, 'Programmation Orientée Objet'), (2, 'Droit Civil'), (2, 'Droit Commercial');");
            } catch (SQLException e) {
                System.out.println("Erreur lors de l'insertion des données : " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } finally {
            // Fermeture des ressources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connexion != null) {
                connexion.close();
            }
        }
    }
}
