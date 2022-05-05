package ru.mirea.task17.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import ru.mirea.task17.tables.Address;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AddressService implements TableService<Address> {

    private final SessionFactory sessionFactory;
    private Session session;

    public AddressService(SessionFactory sessionFactory) {
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
    public void createEntity(Address address) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(address);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Address> readAllEntity() {
        session = sessionFactory.openSession();
        List<Address> addresses = session.createQuery("select i from Address i", Address.class).getResultList();
        for (Address address : addresses)
            Hibernate.initialize(address.getBuildings());
        session.close();
        return addresses;
    }

    @Override
    public boolean deleteAllEntity() {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Address");
        q.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public List<Address> filterByText(String text) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> dogCriteriaQuery =
                builder.createQuery(Address.class);
        Root<Address> root = dogCriteriaQuery.from(Address.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("text"), text));
        List<Address> addresses = session.createQuery(dogCriteriaQuery).getResultList();
        for (Address address : addresses)
            Hibernate.initialize(address.getBuildings());
        session.close();
        return addresses;
    }

    public List<Address> filterByZip(String zip) {
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> dogCriteriaQuery =
                builder.createQuery(Address.class);
        Root<Address> root = dogCriteriaQuery.from(Address.class);

        dogCriteriaQuery.select(root).where(builder.equal(root.get("zip"), zip));
        List<Address> addresses = session.createQuery(dogCriteriaQuery).getResultList();
        for (Address address : addresses)
            Hibernate.initialize(address.getBuildings());
        session.close();
        return addresses;
    }
}
