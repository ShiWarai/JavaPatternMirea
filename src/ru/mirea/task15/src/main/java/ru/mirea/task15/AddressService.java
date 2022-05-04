package ru.mirea.task15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements TableService<Address> {

    private final SessionFactory sessionFactory;
    private Session session;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        List<Address> students = session.createQuery("select i from Address i", Address.class).getResultList();
        session.close();
        return students;
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

}
