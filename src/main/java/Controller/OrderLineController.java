package Controller;


import model.Order;
import model.Order2;
import model.OrderLine;
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

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    public OrderLine createOrderLine(int amount, int o_ID, int i_ID) {
        OrderController orderController = new OrderController();
        ItemController itemController = new ItemController();

        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date = new Date();

        OrderLine orderLine = new OrderLine();
        orderLine.setOL_AMOUNT(amount);
        orderLine.setOL_O_ID(o_ID);
        orderLine.setOL_I_ID(i_ID);
        orderLine.setOL_DELIVERY_D(date);

        orderLine.setOrderlineItem(itemController.getItem(i_ID));
        orderLine.setOL_Order(orderController.getOrder(o_ID));


        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(orderLine);

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
                em.persist(orderLine);
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
        return orderLine;

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

    @RequestMapping(method = RequestMethod.POST)
    OrderLine create(@RequestBody String json) {
        JSONObject jsonnew = new JSONObject(json);
        int amount = jsonnew.getInt("amount");
        int oid = jsonnew.getInt("oid");
        int iid = jsonnew.getInt("iid");
        {

            return createOrderLine(amount, oid, iid);
        }
    }
}
