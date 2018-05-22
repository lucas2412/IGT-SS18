package tools;

import Controller.WarehouseController;
import model.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;

public class main {


    public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {




        System.out.print("Start");


        //accessing JBoss's Transaction can be done differently but this one works nicely
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
        //build the EntityManagerFactory as you would build in in Hibernate ORM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OGM_MONGODB");


        tm.begin();
        EntityManager em = emf.createEntityManager();
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setW_ID(1242);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STEUERSATZ(0.16);
        warehouse1.setW_STRAßE("Ostpreußenring 45");
        warehouse1.setW_YTD("aad");

        em.persist(warehouse1);

        em.flush();
        em.close();
        tm.commit();
        emf.close();

        System.out.print("Ende");
    }
}


