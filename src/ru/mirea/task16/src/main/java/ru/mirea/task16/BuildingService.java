package ru.mirea.task16;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService implements TableService<Building> {

    private final SessionFactory sessionFactory;
    private Session session;

    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(Building building) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(building);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Building> readAllEntity() {
        session = sessionFactory.openSession();
        List<Building> students = session.createQuery("select i from Building i", Building.class).getResultList();
        session.close();
        return students;
    }

    @Override
    public boolean deleteAllEntity() {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Building");
        q.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

}
