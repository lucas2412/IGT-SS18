package Controller;

import model.District;
import model.Warehouse;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

public class WarehouseController {


    public void createWarehouse(Warehouse w) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(w);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateWarehouse(Warehouse w) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Warehouse warehouseOld = entityManager.find(Warehouse.class, w.getW_ID());
        warehouseOld = w;
        entityManager.merge(warehouseOld);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteWarehouse(int W_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Warehouse warehouse = entityManager.find(Warehouse.class, W_ID);

        entityManager.remove(warehouse);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public Warehouse getWarehouse(int W_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Warehouse warehouse = null;

        entityManager.getTransaction().begin();

        warehouse = entityManager.find(Warehouse.class, W_ID);

        entityManager.close();
        factory.close();

        return warehouse;


    }

}
