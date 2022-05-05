package ru.mirea.task17.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.mirea.task17.tables.Building;
import ru.mirea.task17.tables.Building;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class BuildingService implements TableService<Building> {

    private final SessionFactory sessionFactory;
    private Session session;

    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//    }
//
//    @PreDestroy
//    void destroy(){
//        session.close();
//    }

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
        List<Building> buildings = session.createQuery("select i from Building i", Building.class).getResultList();
        session.close();
        return buildings;
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

    public List<Building> filterByDate(String date) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> dogCriteriaQuery =
                builder.createQuery(Building.class);
        Root<Building> root = dogCriteriaQuery.from(Building.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("date"), date));
        List<Building> buildings = session.createQuery(dogCriteriaQuery).getResultList();
        session.close();
        return buildings;
    }

    public List<Building> filterByType(String type) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> dogCriteriaQuery =
                builder.createQuery(Building.class);
        Root<Building> root = dogCriteriaQuery.from(Building.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("type"), type));
        List<Building> buildings = session.createQuery(dogCriteriaQuery).getResultList();
        session.close();
        return buildings;
    }
}
