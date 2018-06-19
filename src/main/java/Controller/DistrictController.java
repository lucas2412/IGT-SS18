package Controller;

import model.Customer;
import model.District;
import model.Warehouse;
import org.springframework.web.bind.annotation.*;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.List;
import java.util.Random;

public class DistrictController {

    public District createDistrict(District d) {
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(d);


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

                em.persist(d);
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
        return d;

    }

    public void updateDistrict(District d) {

        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();

            District districtold = entityManager.find(District.class, d.getD_ID());
            districtold = d;
            entityManager.merge(districtold);


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

                District districtold = em.find(District.class, d.getD_ID());
                districtold = d;
                em.merge(districtold);

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

    public void deleteDistrict(int D_ID) {
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            entityManager.getTransaction().begin();
            District district = entityManager.find(District.class, D_ID);

            entityManager.remove(district);
            entityManager.getTransaction().commit();


            entityManager.close();
            factory.close();
        } else {
            try {

                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                District district = em.find(District.class, D_ID);

                em.remove(district);

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

    public District getDistrict(int D_ID) {
        District district = null;
        if (Config.PERSISTENCE_UNIT_NAME == "MYSQL") {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager entityManager = factory.createEntityManager();

            district = null;

            entityManager.getTransaction().begin();

            district = entityManager.find(District.class, D_ID);

            entityManager.close();
            factory.close();

        } else {
            try {

                TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
                //build the EntityManagerFactory as you would build in in Hibernate ORM
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

                tm.begin();
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                district = em.find(District.class, D_ID);

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
        return district;
    }

    @RequestMapping(method = RequestMethod.POST)
    public District create(@RequestBody District district) {

        return createDistrict(district);
    }


    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public @ResponseBody
    District get(@PathVariable(value = "id", required = true) int id) {

        return getDistrict(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody District district) {

        updateDistrict(district);
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void delete(@PathVariable(value = "id") int id){

        deleteDistrict(id);
    }
}
