
import ma.projet.classes.*;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestAffichageProjet {
    public static void main(String[] args) throws ParseException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Création des employés
        Employe chef = new Employe();
        chef.setNom("KAWTAR");
        chef.setPrenom("TNS");
        chef.setTelephone("060666456");
        session.save(chef);

        Employe employe1 = new Employe();
        employe1.setNom("KAWTAR");
        employe1.setPrenom("TANASSA");
        employe1.setTelephone("066598966");
        session.save(employe1);

        // Création du projet
        Projet projet = new Projet();projet.setId(4);
        projet.setNom("Gestion de stock");
        projet.setDateDebut(sdf.parse("14/01/2013"));
        projet.setDateFin(sdf.parse("30/04/2013"));
        projet.setChef(chef);
        session.save(projet);

        // Création des tâches
        Tache t1 = new Tache();t1.setId(12);
        t1.setNom("Analyse");
        t1.setDateDebut(sdf.parse("10/02/2013"));
        t1.setDateFin(sdf.parse("20/02/2013"));
        t1.setPrix(500);
        t1.setProjet(projet);
        session.save(t1);

        Tache t2 = new Tache();t2.setId(13);
        t2.setNom("Conception");
        t2.setDateDebut(sdf.parse("10/03/2013"));
        t2.setDateFin(sdf.parse("15/03/2013"));
        t2.setPrix(1200);
        t2.setProjet(projet);
        session.save(t2);

        Tache t3 = new Tache();t3.setId(15);
        t3.setNom("Développement");
        t3.setDateDebut(sdf.parse("10/04/2013"));
        t3.setDateFin(sdf.parse("25/04/2013"));
        t3.setPrix(2000);
        t3.setProjet(projet);
        session.save(t3);

        // Association Employe <-> Tache
        EmployeTache et1 = new EmployeTache();
        et1.setEmploye(employe1);
        et1.setTache(t1);
        et1.setDateDebutReelle(sdf.parse("10/02/2013"));
        et1.setDateFinReelle(sdf.parse("20/02/2013"));
        session.save(et1);

        EmployeTache et2 = new EmployeTache();
        et2.setEmploye(employe1);
        et2.setTache(t2);
        et2.setDateDebutReelle(sdf.parse("10/03/2013"));
        et2.setDateFinReelle(sdf.parse("15/03/2013"));
        session.save(et2);

        EmployeTache et3 = new EmployeTache();
        et3.setEmploye(employe1);
        et3.setTache(t3);
        et3.setDateDebutReelle(sdf.parse("10/04/2013"));
        et3.setDateFinReelle(sdf.parse("25/04/2013"));
        session.save(et3);

        tx.commit();
        if(projet != null) {
            System.out.println("Projet : " + projet.getId() +
                    "      Nom : " + projet.getNom() +
                    "     Date début : " + sdf.format(projet.getDateDebut()));
            System.out.println("Liste des tâches:");
            System.out.printf("%-4s %-15s %-18s %-18s%n", "Num", "Nom", "Date Début Réelle", "Date Fin Réelle");

            Query<EmployeTache> query = session.createQuery(
                    "FROM EmployeTache et WHERE et.tache.projet.id = :projetId", EmployeTache.class);
            query.setParameter("projetId", projet.getId());
            List<EmployeTache> taches = query.list();

            for(EmployeTache et : taches) {
                System.out.printf("%-4d %-15s %-18s %-18s%n",
                        et.getTache().getId(),
                        et.getTache().getNom(),
                        et.getDateDebutReelle() != null ? sdf.format(et.getDateDebutReelle()) : "N/A",
                        et.getDateFinReelle() != null ? sdf.format(et.getDateFinReelle()) : "N/A"
                );
            }
        }

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
