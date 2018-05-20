package Controller;

import model.OrderLine;
import model.Stock;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StockController {

    public void createStock(Stock s) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(s);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
    //TODO Primärschlüssel?
    public void updateOrderLine(Stock s) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Stock stockold = entityManager.find(Stock.class, s.getS_I_ID());
        stockold = s;
        entityManager.merge(stockold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteStock(int S_I_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Stock stock = entityManager.find(Stock.class, S_I_ID);

        entityManager.remove(stock);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public Stock getStock(int S_I_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Stock stock = null;

        entityManager.getTransaction().begin();

        stock = entityManager.find(Stock.class, S_I_ID);

        entityManager.close();
        factory.close();

        return stock;


    }
}
