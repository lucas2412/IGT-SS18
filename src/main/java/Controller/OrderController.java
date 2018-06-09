package Controller;

import model.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    public Order2 createOrder(int C_ID, int orderLineAmount) {
        CustomerController customerController = new CustomerController();
        NewOrderController newOrderController = new NewOrderController();

        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date = new Date();

        Order2 order = new Order2();
        order.setO_C_ID(C_ID);
        order.setO_OL_CNT(orderLineAmount);
        order.setO_EINGANGSDATUM(date);
        order.setCustomer(customerController.getCustomer(C_ID));
      //  order.setNewOrder();



        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(order);
            System.out.println("------------------------------" +order.getO_ID());


            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
            newOrderController.createNewOrder(order);

        } else {

            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();
                em.persist(order);

                em.flush();
                em.close();
                tm.commit();
                emf.close();
                newOrderController.createNewOrder(order);
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
        return order;
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

    public Order2 getOrder(int O_ID) {
        Order2 order = null;
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            order = entityManager.find(Order2.class, O_ID);

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
                order = em.find(Order2.class, O_ID);
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
        return order;
    }

    public List<Order2> getAllOrders(int c_ID) {
        List<Order2> orders = null;
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            String a = "DAS";
            orders = entityManager.createQuery("SELECT i FROM Order2 i").getResultList();

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

                orders = em.createQuery("SELECT i FROM Order2 i").getResultList();

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
        return orders;
    }
/*
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public @ResponseBody
    Order2 create(@RequestParam(value ="cid", required = true) int cid,
                  @RequestParam(value ="olAmount", required = true) int olAmount)
    {

        return createOrder(cid, olAmount);
    }
*/
    @RequestMapping(method = RequestMethod.POST)
    public Order2 create(@RequestBody String json) {

        JSONObject jsonnew = new JSONObject(json);
        int cid = jsonnew.getInt("cid");
        int olAmount = jsonnew.getInt("olAmount");

        return createOrder(cid, olAmount);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Order2> getAll(@RequestParam(value ="cid", required = true) int cid)
    {

        return getAllOrders(cid);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Order2 get(@RequestParam(value ="oid", required = true) int oid)
    {

        return getOrder(oid);
    }
}
