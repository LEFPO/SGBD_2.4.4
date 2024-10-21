package main.java.DAL.Section;

import java.util.ArrayList;

import main.java.BL.Section.*;

public interface IDAOCours {
    boolean addCours(String nom, int idSection);
    boolean updateCours(int id, String nom, int idSection);
    boolean deleteCours(int id);
    ArrayList<Cours> getCours();
    int getIDCours(String nom);
}
