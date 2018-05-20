package Controller;

import model.Item;
import model.NewOrder;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewOrderController {

    public void createNewOrder(NewOrder no) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(no);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateNewOrder(NewOrder no) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        NewOrder newOrderold = entityManager.find(NewOrder.class, no.getNO_O_ID());
        newOrderold = no;
        entityManager.merge(newOrderold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteNewOrder(int NO_O_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        NewOrder newOrder = entityManager.find(NewOrder.class, NO_O_ID );

        entityManager.remove(newOrder);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public NewOrder NewOrder(int NO_O_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        NewOrder newOrder = null;

        entityManager.getTransaction().begin();

        newOrder = entityManager.find(NewOrder.class, NO_O_ID);

        entityManager.close();
        factory.close();

        return newOrder;


    }
}
