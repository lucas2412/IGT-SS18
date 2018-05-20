package Controller;

import model.History;
import model.Order;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderController {

    public void createOrder(Order o) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(o);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateOrder(Order o) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Order orderOld = entityManager.find(Order.class, o.getO_ID());
        orderOld = o;
        entityManager.merge(orderOld);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteOrder(int O_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, O_ID);

        entityManager.remove(order);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public Order getHistory(int O_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Order order = null;

        entityManager.getTransaction().begin();

        order = entityManager.find(Order.class, O_ID);

        entityManager.close();
        factory.close();

        return order;


    }
}
