package ma.projet.classes;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String telephone;

    @OneToMany(mappedBy = "employe")
    private List<EmployeTache> employeTaches;

    @OneToMany(mappedBy = "chef")
    private List<Projet> projetsGeres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<EmployeTache> getEmployeTaches() {
        return employeTaches;
    }

    public void setEmployeTaches(List<EmployeTache> employeTaches) {
        this.employeTaches = employeTaches;
    }

    public List<Projet> getProjetsGeres() {
        return projetsGeres;
    }

    public void setProjetsGeres(List<Projet> projetsGeres) {
        this.projetsGeres = projetsGeres;
    }
}
