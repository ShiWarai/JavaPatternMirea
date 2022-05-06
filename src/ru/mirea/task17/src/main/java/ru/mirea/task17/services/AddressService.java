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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Address> filterBy(String text, String zip){
        List<Address> addresses;

        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> root = query.from(Address.class);

        if (text != null && zip != null){
            query.select(root).where(builder.and(builder.equal(root.get("text"), text),
                                                builder.equal(root.get("zip"), zip)));
        }
        else if(text != null)
            query.select(root).where(builder.equal(root.get("text"), text));
        else if (zip != null) {
            query.select(root).where(builder.equal(root.get("zip"), zip));
        }

        addresses = session.createQuery(query).getResultList();
        for (Address address : addresses)
            Hibernate.initialize(address.getBuildings());
        session.close();

        return addresses;
    }

    public List<Address> filterByText(String text) {
        return filterBy(text, null);
    }

    public List<Address> filterByZip(String zip) {
        return filterBy(null, zip);
    }
}
