package ma.projet.classes;
import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeTache {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateDebutReelle;
    private Date dateFinReelle;

    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name="tache_id")
    private Tache tache;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}