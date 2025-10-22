package ma.projet.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ma.projet.classes.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Projet.class);
            configuration.addAnnotatedClass(Tache.class);
            configuration.addAnnotatedClass(Employe.class);
            configuration.addAnnotatedClass(EmployeTache.class);
            return configuration.buildSessionFactory();
        } catch (Exception ex) {
            throw new RuntimeException("Erreur de configuration Hibernate", ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
