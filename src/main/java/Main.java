package main.java;

import java.sql.Connection;
import java.sql.SQLException;

import main.java.DAL.Section.DAOCours;
import main.java.DAL.Section.DAOSection;
import main.java.DAL.Section.DAOStatus;
import main.java.Factory.DBConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbName = "ecole";
        String url = "jdbc:postgresql://127.0.0.1/" + dbName;  // Base de données complète
        String user = "postgres";
        String password = "Arkana10021994";

        // Créer la base de données si elle n'existe pas déjà
        DBConnection.createDatabase(dbName);

        // Connexion à la base de données "ecole"
        Connection connection = DBConnection.connect(dbName);

        // Passer la connexion à DAOCours au lieu de null
        DAOSection section = new DAOSection(url, user, password);
        DAOStatus status = new DAOStatus(url, user, password);
        DAOCours cours = new DAOCours(url, user, password);
        

        // Ajout de statuts
        status.addStatus("Etudiant");
        status.addStatus("Charge de cours");
        status.addStatus("Employé administratif");

        // Ajout de sections
        section.addSection("Informatique de gestion");
        section.addSection("Droit");

        // Ajout de cours (en faisant attention à la taille des noms des cours)
        cours.addCours("Base de réseaux", 1);
        cours.addCours("Système d'exploitation", 1);
        cours.addCours("Programmation orientée objet", 1);
        cours.addCours("Droit civil", 2);
        cours.addCours("Droit commercial", 2);

        // Fermer la connexion après les opérations
        if (connection != null) {
            connection.close();
        }
    }
}
