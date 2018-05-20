package Controller;

import model.Customer;
import model.District;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerController {

    public void createCustomer(Customer c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(c);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateCustomer(Customer c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customerold = entityManager.find(Customer.class, c.getC_ID());
        customerold = c;
        entityManager.merge(customerold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteCustomer(int C_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, C_ID);

        entityManager.remove(customer);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public Customer getCustomer(int C_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Customer customer = null;

        entityManager.getTransaction().begin();

        customer = entityManager.find(Customer.class, C_ID);

        entityManager.close();
        factory.close();

        return customer;


    }
}
