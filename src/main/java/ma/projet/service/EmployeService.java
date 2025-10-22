package ma.projet.service;

import ma.projet.classes.Employe;
import ma.projet.dao.IDao;
import java.util.List;

public interface EmployeService extends IDao<Employe> {
    List<String> listeTachesRealisees(int employeId);
    List<String> listeProjetsGeres(int employeId);
}
