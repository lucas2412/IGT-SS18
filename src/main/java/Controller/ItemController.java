package Controller;

import model.*;
import org.springframework.web.bind.annotation.*;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/item")
public class ItemController {

    public Item createItem(String name, double preis) {
        Item item = new Item();
        item.setI_NAME(name);
        item.setI_PRICE(preis);
        item.setOrderlineList(new ArrayList<OrderLine>());
        item.setStockList(new ArrayList<Stock>());

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(item);

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
                em.persist(item);
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
        return item;
    }

    public Item updateItem(int id, String name, Double preis) {
        Item item = new Item();
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            item = entityManager.find(Item.class, id);
            if (name != null) {
                item.setI_NAME(name);
            }
            if (preis != null) {
                item.setI_PRICE(preis);
            }
            entityManager.merge(item);

            entityManager.getTransaction().commit();


            entityManager.close();
            factory.close();

        }
        else {
            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                item = em.find(Item.class, id);
                if (name != null) {
                    item.setI_NAME(name);
                }
                if (preis != null) {
                    item.setI_PRICE(preis);
                }
                em.merge(item);

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
        return item;

    }

    public boolean deleteItem(int I_ID) {
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            Item item = entityManager.find(Item.class, I_ID);

            entityManager.remove(item);
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();

        }else {
            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                Item item = em.find(Item.class, I_ID);
                em.remove(item);

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

    public Item getItem(int I_ID) {
        Item item = new Item();

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            item = entityManager.find(Item.class, I_ID);

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

                item = em.find(Item.class, I_ID);

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
        return item;


    }


    public List<Item> getAllItems() {
        List itemList = null;

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            itemList = entityManager.createQuery("SELECT i FROM Item i").getResultList();

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

                itemList = em.createQuery("SELECT i FROM Item i").getResultList();


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
        return itemList;


    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public @ResponseBody
    Item create(@RequestParam(value ="name", required = true) String name,
                    @RequestParam(value ="preis", required = true) Double preis)
    {

        return createItem(name,preis);
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Item get(@PathVariable(value = "id", required = true) int id) {

        return getItem(id);
    }


    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Item> getAll() {

        return getAllItems();
    }
    @RequestMapping(value="/update", method = RequestMethod.GET)
    public Item update(@RequestParam(value ="id", required = true) int id,
                           @RequestParam(value ="name", required = false) String name,
                           @RequestParam(value ="preis", required = false) Double preis)
    {
        return updateItem(id,name,preis);
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public @ResponseBody
    boolean delete(@RequestParam(value = "id") int id){

        return deleteItem(id);
    }
}
