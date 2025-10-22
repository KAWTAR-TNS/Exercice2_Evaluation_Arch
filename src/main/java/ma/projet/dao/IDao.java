package ma.projet.dao;
import java.util.List;

public interface IDao<T> {
    void create(T o);
    void update(T o);
    void delete(T o);
    T findById(int id);
    List<T> findAll();
}
