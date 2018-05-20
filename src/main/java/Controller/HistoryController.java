package Controller;

import model.Customer;
import model.History;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HistoryController {

    public void createHistory(History h) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(h);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateHistory(History h) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        History historyold = entityManager.find(History.class, h.getH_ID());
        historyold = h;
        entityManager.merge(historyold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteHistory(int H_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        History history = entityManager.find(History.class, H_ID);

        entityManager.remove(history);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public History getHistory(int H_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        History history = null;

        entityManager.getTransaction().begin();

        history = entityManager.find(History.class, H_ID);

        entityManager.close();
        factory.close();

        return history;


    }
}
