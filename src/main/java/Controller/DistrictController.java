package Controller;

import model.District;
import model.Warehouse;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DistrictController {

    public void createDistrict(District d) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(d);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

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
