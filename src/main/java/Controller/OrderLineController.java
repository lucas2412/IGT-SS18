package Controller;


import model.Order;
import model.OrderLine;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderLineController {

    public void createOrderLine(OrderLine ol) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(ol);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
    //TODO Primärschlüssel
    public void updateOrderLine(OrderLine ol) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        OrderLine orderlineOld = entityManager.find(OrderLine.class, ol.getOL_NUMBER());
        orderlineOld = ol;
        entityManager.merge(orderlineOld);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteOrderLine(int O_NUMBER) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        OrderLine orderLine = entityManager.find(OrderLine.class, O_NUMBER);

        entityManager.remove(orderLine);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public OrderLine getOrderLine(int O_NUMBER) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        OrderLine orderLine = null;

        entityManager.getTransaction().begin();

        orderLine = entityManager.find(OrderLine.class, O_NUMBER);

        entityManager.close();
        factory.close();

        return orderLine;


    }
}
