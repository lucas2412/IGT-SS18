package Controller;

import model.History;
import model.Order;
import model.Order2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    public void createOrder(int C_ID, int itemcount) {
        Order2 order = new Order2();
        order.setO_C_ID(C_ID);
        order.setO_OL_CNT(itemcount);

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

       //     entityManager.persist(w);

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
            //    em.persist(w);
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

    public Order getHistory(int O_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Order order = null;

        entityManager.getTransaction().begin();

        order = entityManager.find(Order.class, O_ID);

        entityManager.close();
        factory.close();

        return order;


    }
}
