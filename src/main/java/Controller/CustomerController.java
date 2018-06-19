package Controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    Date date = new Date();



    public Customer createCustomer(Customer customer) {

        customer.setC_RABATT(0.0);
        customer.setC_KONTOSTAND(0.0);
        customer.setC_KUNDESEIT(date);



        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            if (customer.getC_D_ID() == null){

                Query query = entityManager.createQuery("Select upper(t.D_ID) from District t");
                List list =  query.setMaxResults(5).getResultList();
                int size = list.size();

                Random ran = new Random();
                int id = ran.nextInt(size);
                System.out.print(id + "------------------------------------------");
                Integer D_ID = (Integer) list.get(id);
                customer.setC_D_ID(D_ID);
                customer.setCustomerDistrict(entityManager.find(District.class,D_ID));

            }
            entityManager.persist(customer);


            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();



        }

        else{

            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();

                EntityManager em = emf.createEntityManager();
                if (customer.getC_D_ID() == null){

                    Query query = em.createQuery("Select upper(t.D_ID) from District t");
                    List list =  query.setMaxResults(5).getResultList();
                    int size = list.size();
                    if (Config.PERSISTENCE_UNIT_NAME == "OGM_REDIS" || Config.PERSISTENCE_UNIT_NAME == "OGM_CASSANDRA" ) {
                        customer.setC_D_ID(2);
                        customer.setCustomerDistrict(em.find(District.class,2));
                    } else {

                        Random ran = new Random();
                        int id = ran.nextInt(size);
                        System.out.print(id + "------------------------------------------");
                        System.out.print(list.get(id).toString());
                        Integer D_ID = (Integer) list.get(id);
                        customer.setC_D_ID(D_ID);
                        customer.setCustomerDistrict(em.find(District.class,D_ID));
                    }


                }

                em.persist(customer);
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
        return customer;
    }

    public Customer updateCustomer(int id, Customer newCustomer) {

        Customer oldCustomer = null;

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            oldCustomer = entityManager.find(Customer.class, id);
            if (newCustomer.getC_STADT() != null) {
                oldCustomer.setC_STADT(newCustomer.getC_STADT());
            }
            if (newCustomer.getC_STRASSE() != null) {
                oldCustomer.setC_STRASSE(newCustomer.getC_STRASSE());
            }
            if (newCustomer.getC_PLZ() != null) {
                oldCustomer.setC_PLZ(newCustomer.getC_PLZ());
            }

            if (newCustomer.getC_TELEFONNUMMER() != null) {
                oldCustomer.setC_TELEFONNUMMER(newCustomer.getC_TELEFONNUMMER());
            }

            if (newCustomer.getC_D_ID() != null) {
                oldCustomer.setC_D_ID(newCustomer.getC_D_ID());
            }

            if (newCustomer.getC_RABATT() != null) {
                oldCustomer.setC_RABATT(newCustomer.getC_RABATT());
            }

            if (newCustomer.getC_KONTOSTAND() != null) {
                oldCustomer.setC_KONTOSTAND(newCustomer.getC_KONTOSTAND());
            }


            entityManager.merge(oldCustomer);

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
                oldCustomer = em.find(Customer.class, id);
                if (newCustomer.getC_STADT() != null) {
                    oldCustomer.setC_STADT(newCustomer.getC_STADT());
                }
                if (newCustomer.getC_STRASSE() != null) {
                    oldCustomer.setC_STRASSE(newCustomer.getC_STRASSE());
                }
                if (newCustomer.getC_PLZ() != null) {
                    oldCustomer.setC_PLZ(newCustomer.getC_PLZ());
                }

                if (newCustomer.getC_TELEFONNUMMER() != null) {
                    oldCustomer.setC_TELEFONNUMMER(newCustomer.getC_TELEFONNUMMER());
                }

                if (newCustomer.getC_D_ID() != null) {
                    oldCustomer.setC_D_ID(newCustomer.getC_D_ID());
                }

                if (newCustomer.getC_RABATT() != null) {
                    oldCustomer.setC_RABATT(newCustomer.getC_RABATT());
                }

                if (newCustomer.getC_KONTOSTAND() != null) {
                    oldCustomer.setC_KONTOSTAND(newCustomer.getC_KONTOSTAND());
                }


                em.merge(oldCustomer);

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
        return oldCustomer;
    }

    public boolean deleteCustomer(int C_ID) {
        NewOrderController newOrderController = new NewOrderController();

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class, C_ID);

            // bevor Customer gelöscht werden kann, müssen Abhängigkeiten gelöscht werden.
            List<Order2> orderList = customer.getOrders();

            for (int i = 0; i < orderList.size(); i++){
                List<OrderLine> orderLinelist =  orderList.get(i).getOrderLines();
                /*
                for (int x = 0; x < orderLinelist.size(); x++){
                    OrderLine orderline = orderLinelist.get(x);
                    entityManager.remove(orderline);

                }
                 */


                Order2 order = orderList.get(i);
                Query query = entityManager.createQuery( "Select NO_ID from NewOrder no where no.NO_O_ID = ?1" );
                query.setParameter( 1, order.getO_ID());

                Integer b  = (Integer) query.getSingleResult();
                NewOrder newOrder = entityManager.find(NewOrder.class, b);

                entityManager.remove(newOrder);
           //     entityManager.remove(order);
            }




            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();

       /* }else if (Config.PERSISTENCE_UNIT_NAME == "NEO4J") {
            return true; */
        }
        else{
            try {
                //accessing JBoss's Transaction can be done differently but this one works nicely
                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                Customer customer = em.find(Customer.class, C_ID);
/*
                List<Order2> orderList = customer.getOrders();
                for (int i = 0; i < orderList.size(); i++){
                    List<OrderLine> orderLinelist =  orderList.get(i).getOrderLines();
                    for (int x = 0; x < orderLinelist.size(); x++){
                        OrderLine orderline = orderLinelist.get(x);
                        em.remove(orderline);

                    }
                    Order2 order = orderList.get(i);
                    Query query = em.createQuery( "Select NO_ID from NewOrder no where no.NO_O_ID = ?1" );
                    System.out.println(order.getO_ID()+ "------------------------------");
                    query.setParameter( 1, (int) order.getO_ID());

                    Integer b  = (Integer) query.getSingleResult();
                    NewOrder newOrder = em.find(NewOrder.class, b);

                    em.remove(newOrder);
                    em.remove(order);
                }
*/

                em.remove(customer);

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

    public Customer getCustomer(int C_ID) {
        Customer customer = new Customer();

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            customer = entityManager.find(Customer.class, C_ID);

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

                customer = em.find(Customer.class, C_ID);

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
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {

        return createCustomer(customer);
    }


    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Customer get(@PathVariable(value = "id", required = true) int id) {

        return getCustomer(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Customer update(@PathVariable int id, @RequestBody Customer customer) {

        return updateCustomer(id, customer);
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean delete(@PathVariable(value = "id") int id){

        return deleteCustomer(id);
    }
}
