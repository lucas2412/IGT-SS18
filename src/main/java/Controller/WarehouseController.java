package Controller;

import model.Customer;
import model.District;
import model.Stock;
import model.Warehouse;
import org.springframework.web.bind.annotation.*;
import tools.Config;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.util.List;



@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    public Warehouse createWarehouse(Warehouse w) {

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

        return w;
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

    public int getItemStock(int W_ID, int S_I_ID) {
        Warehouse w = new Warehouse();
        int bestand = 0;
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            w = entityManager.find(Warehouse.class, W_ID);
            List list = w.getStockList();

            for (int i = 0; list.size() > i; i++ ){
                Stock stock = (Stock) list.get(i);
                System.out.println("----------" + stock.getS_QUANTITY());
                if (stock.getS_I_ID() == S_I_ID){
                    bestand+= stock.getS_QUANTITY();
                }
            }

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
                List list = w.getStockList();
                for (int i = 0; list.size() > i; i++ ){
                    Stock stock = new Stock();
                    if (stock.getS_I_ID() == S_I_ID){
                        bestand+= stock.getS_QUANTITY();
                    }
                }

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
        return bestand;
    }

    public boolean reduceStock( int W_ID, int S_I_ID, int anzahl) {
        Warehouse w = new Warehouse();

        int anzahlneu = anzahl;
        int bestand = 0;
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            w = entityManager.find(Warehouse.class, W_ID);
            List list = w.getStockList();

            for (int i = 0; list.size() > i && anzahlneu > 0; i++ ){
                Stock stock = (Stock) list.get(i);
                System.out.println("----------" + stock.getS_QUANTITY());
                if (stock.getS_I_ID() == S_I_ID){
                    if (stock.getS_QUANTITY() < anzahlneu){
                        anzahlneu -= stock.getS_QUANTITY();
                        stock.setS_QUANTITY(0);
                    }else {
                        stock.setS_QUANTITY(stock.getS_QUANTITY()-anzahlneu);
                        anzahlneu = 0;
                    }

                }
            }

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
                List list = w.getStockList();
                for (int i = 0; list.size() > i && anzahlneu > 0; i++ ){
                    Stock stock = (Stock) list.get(i);
                    System.out.println("----------" + stock.getS_QUANTITY());
                    if (stock.getS_I_ID() == S_I_ID){
                        if (stock.getS_QUANTITY() < anzahlneu){
                            anzahlneu -= stock.getS_QUANTITY();
                            stock.setS_QUANTITY(0);
                        }else {
                            stock.setS_QUANTITY(stock.getS_QUANTITY()-anzahlneu);
                        }

                    }
                }

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
        return true;
    }

    public boolean addStock(int W_ID, int S_I_ID, int anzahl) {
        Warehouse w = new Warehouse();
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            w = entityManager.find(Warehouse.class, W_ID);
            List list = w.getStockList();

            for (int i = 0; list.size() > i; i++ ){
                Stock stock = (Stock) list.get(i);
                System.out.println("----------" + stock.getS_QUANTITY());
                if (stock.getS_I_ID() == S_I_ID){
                  stock.setS_QUANTITY(stock.getS_QUANTITY()+anzahl);

                }
            }

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
                List list = w.getStockList();

                for (int i = 0; list.size() > i; i++ ){
                    Stock stock = (Stock) list.get(i);
                    System.out.println("----------" + stock.getS_QUANTITY());
                    if (stock.getS_I_ID() == S_I_ID){
                        stock.setS_QUANTITY(stock.getS_QUANTITY()+anzahl);

                    }
                }

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
        return true;
    }


    @RequestMapping(value="/getStock", method = RequestMethod.GET)
    public int update(@RequestParam(value ="wid", required = true) int wid,
                           @RequestParam(value ="iid", required = true) int iid)
    {

        return getItemStock(wid,iid);
    }


    @RequestMapping(value="/addStock", method = RequestMethod.PUT)
    public boolean add(@RequestBody String json) {
        JSONObject jsonnew = new JSONObject(json);
        int wid = jsonnew.getInt("wid");
        int iid = jsonnew.getInt("iid");
        int anzahl = jsonnew.getInt("anzahl");

        return addStock(wid,iid,anzahl);
    }

    @RequestMapping(value="/reduceStock", method = RequestMethod.PUT)
    public boolean reduce(@RequestBody String json) {
        JSONObject jsonnew = new JSONObject(json);
        int wid = jsonnew.getInt("wid");
        int iid = jsonnew.getInt("iid");
        int anzahl = jsonnew.getInt("anzahl");

        return reduceStock(wid,iid,anzahl);
    }
}
