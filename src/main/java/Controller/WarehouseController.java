package Controller;

import model.District;
import model.Warehouse;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class WarehouseController {


    //TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

    EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);

    EntityManager entityManager = factory.createEntityManager();



    public void createWarehouse() {

        entityManager.getTransaction().begin();
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setW_ID(1);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STEUERSATZ(0.16);
        warehouse1.setW_STRAßE("Ostpreußenring 45");
        warehouse1.setW_YTD("aad");

        entityManager.persist(warehouse1);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }




}
