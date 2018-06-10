package Controller;

import model.District;
import model.Warehouse;
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        District districtold = entityManager.find(District.class, d.getD_ID());
        districtold = d;
        entityManager.merge(districtold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteDistrict(int D_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        District district = entityManager.find(District.class, D_ID);

        entityManager.remove(district);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public District getDistrict(int D_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        District district = null;

        entityManager.getTransaction().begin();

        district = entityManager.find(District.class, D_ID);

        entityManager.close();
        factory.close();

        return district;


    }
}
