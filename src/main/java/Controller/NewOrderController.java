package Controller;

import model.Item;
import model.NewOrder;
import model.Order2;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

public class NewOrderController {

    public void createNewOrder(Order2 order) {
        OrderController orderController = new OrderController();
        NewOrder newOrder = new NewOrder();

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            newOrder.setNO_O_ID(order.getO_ID());
            newOrder.setNewOrder(order);

            entityManager.persist(newOrder);

        //    order.setNewOrder(newOrder);
         //   entityManager.merge(order);

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

                newOrder.setNO_O_ID(order.getO_ID());
                newOrder.setNewOrder(order);

                em.persist(newOrder);

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
     //   return newOrder;
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

    public NewOrder getNewOrder(int NO_O_ID) {
        NewOrder newOrder = new NewOrder();

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            newOrder = entityManager.find(NewOrder.class, NO_O_ID);


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

                newOrder = em.find(NewOrder.class, NO_O_ID);

                em.persist(newOrder);

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
        return newOrder;
    }
}
