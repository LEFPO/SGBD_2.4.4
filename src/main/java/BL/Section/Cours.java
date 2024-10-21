package main.java.BL.Section;

public class Cours {
    private final int id;
    private Section id_section;
    private String nom;

    public Cours(int id, Section id_section, String nom) {
        this.id = id;
        this.id_section = id_section;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public Section getId_section() {
        return id_section;
    }

    public void setId_section(Section id_section) {
        this.id_section = id_section;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

}
