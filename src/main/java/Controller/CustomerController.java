package Controller;

import model.Customer;
import model.District;
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


    public Customer createCustomer(String stadt, String straße, String plz, String tel) {



        Customer customer = new Customer();
        customer.setC_STADT(stadt);
        customer.setC_STRAßE(straße);
        customer.setC_PLZ(plz);
        customer.setC_TELEFONNUMMER(tel);

        customer.setC_RABATT(0.0);
        customer.setC_KONTOSTAND(0.0);
        customer.setC_KUNDESEIT(date);



        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("Select upper(t.D_ID) from District t");
            List list =  query.setMaxResults(5).getResultList();
            int size = list.size();

            Random ran = new Random();
            int id = ran.nextInt(size);
            System.out.print(id + "------------------------------------------");
            Integer D_ID = (Integer) list.get(id);
            customer.setC_D_ID(D_ID);
            customer.setCustomerDistrict(entityManager.find(District.class,D_ID));


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

                Query query = em.createQuery("Select upper(t.D_ID) from District t");
                List list =  query.setMaxResults(5).getResultList();
                int size = list.size();

                Random ran = new Random();
                int id = ran.nextInt(size);
                System.out.print(id + "------------------------------------------");
                Integer D_ID = (Integer) list.get(id);
                customer.setC_D_ID(D_ID);
                customer.setCustomerDistrict(em.find(District.class,D_ID));

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

    public Customer updateCustomer(int id, String stadt, String straße, String plz, String tel, Integer districtid, Double rabatt, Double kontostand) {

        Customer customer = new Customer();
        System.out.print(stadt);
        System.out.print(straße);
        System.out.print(rabatt);
        System.out.print(kontostand);
        System.out.print(districtid);
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            customer = entityManager.find(Customer.class, id);
            if (stadt != null) {
                System.out.print("stadt289174872893712931927839123");
                System.out.print(stadt);
                customer.setC_STADT(stadt);
            }
            if (straße != null) {
                System.out.print("straße23412312312312312323123123");
                System.out.print(straße);
                customer.setC_STRAßE(straße);
            }
            if (plz != null) {
                customer.setC_PLZ(plz);
            }
            if (tel != null) {
                customer.setC_TELEFONNUMMER(tel);
            }
            if (districtid != null) {
                customer.setC_D_ID(districtid);
                customer.setCustomerDistrict(entityManager.find(District.class,districtid));
            }
            if (rabatt != null) {
                customer.setC_RABATT(rabatt);
            }
            if (kontostand != null) {
                customer.setC_KONTOSTAND(kontostand);
            }
            entityManager.merge(customer);

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

                customer = em.find(Customer.class, id);
                customer.setC_STADT(stadt);
                customer.setC_STRAßE(straße);
                customer.setC_PLZ(plz);
                customer.setC_TELEFONNUMMER(tel);
                //  customer.setCustomerDistrict(entityManager.find(District.class,districtid));
                customer.setC_D_ID(districtid);
                customer.setC_RABATT(rabatt);
                customer.setC_KONTOSTAND(kontostand);
                em.merge(customer);

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

    public boolean deleteCustomer(int C_ID) {

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class, C_ID);

            entityManager.remove(customer);
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

                Customer customer = em.find(Customer.class, C_ID);
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public @ResponseBody
    Customer create(@RequestParam(value ="strasse", required = true) String strasse,
                    @RequestParam(value ="stadt", required = true) String stadt,
                    @RequestParam(value ="plz", required = true) String plz,
                    @RequestParam(value ="tel", required = true) String tel)
                    {

        return createCustomer(strasse,stadt, tel, plz);
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Customer get(@PathVariable(value = "id", required = true) int id) {

        return getCustomer(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.GET)
    public Customer update(@RequestParam(value ="id", required = true) int id,
                               @RequestParam(value ="straße", required = false) String straße,
                               @RequestParam(value ="stadt", required = false) String stadt,
                               @RequestParam(value ="plz", required = false) String plz,
                               @RequestParam(value ="tel", required = false) String tel,
                               @RequestParam(value ="rabatt", required = false) Double rabatt,
                               @RequestParam(value ="kontostand", required = false) Double kontostand,
                               @RequestParam(value ="district", required = false) Integer district)
    {

        return updateCustomer(id,stadt,straße,plz,tel,district,rabatt, kontostand);
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public @ResponseBody
    boolean delete(@RequestParam(value = "id") int id){

        return deleteCustomer(id);
    }
}
