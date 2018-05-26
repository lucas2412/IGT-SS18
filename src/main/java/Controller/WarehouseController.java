package Controller;

import model.District;
import model.Warehouse;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

public class WarehouseController {





    public void createWarehouse(Warehouse w) {

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(w);

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
                em.persist(w);
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
    }


    public void updateWarehouse(Warehouse w) {

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.getTransaction().begin();
            Warehouse warehouseOld = entityManager.find(Warehouse.class, w.getW_ID());
            warehouseOld = w;
            entityManager.merge(warehouseOld);

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();

        } else {

            try {

                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                Warehouse warehouseOld = em.find(Warehouse.class, w.getW_ID());
                warehouseOld = w;
                em.merge(warehouseOld);

                em.getTransaction().commit();

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
    }

    public void deleteWarehouse(int W_ID) {
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            Warehouse warehouse = entityManager.find(Warehouse.class, W_ID);

            entityManager.remove(warehouse);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();

        } else {

            try {

                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                Warehouse warehouse = em.find(Warehouse.class, W_ID);

                em.remove(warehouse);
                em.getTransaction().commit();

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
    }

    public Warehouse getWarehouse(int W_ID) {
        Warehouse w = new Warehouse();
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            w = entityManager.find(Warehouse.class, W_ID);

            entityManager.getTransaction().commit();


            entityManager.close();
            factory.close();

        } else {
            try {

                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                w = em.find(Warehouse.class, W_ID);

                em.getTransaction().commit();

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
        return w;
    }
}
