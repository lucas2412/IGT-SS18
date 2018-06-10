package Controller;

import model.OrderLine;
import model.Stock;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

public class StockController {

    public Stock createStock(Stock s) {
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(s);

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        } else {
            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();

                EntityManager em = emf.createEntityManager();
                em.persist(s);
                em.flush();
                em.close();
                tm.commit();
                emf.close();

            } catch (NotSupportedException e) {
                e.printStackTrace();
            } catch (SystemException e) {
                e.printStackTrace();
            } catch (RollbackException e) {
                e.printStackTrace();
            } catch (HeuristicMixedException e) {
                e.printStackTrace();
            } catch (HeuristicRollbackException e) {
                e.printStackTrace();
            }
        }
        return s;
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
