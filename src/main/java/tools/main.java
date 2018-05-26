package tools;

import Controller.WarehouseController;
import model.Order;
import model.OrderLine;
import model.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class main {


    public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {




        System.out.print("Start");

/*
        //accessing JBoss's Transaction can be done differently but this one works nicely
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
        //build the EntityManagerFactory as you would build in in Hibernate ORM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);


        tm.begin();
        EntityManager em = emf.createEntityManager();
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setW_ID(2);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STRAßE("Ostpreußenring 45");

        em.persist(warehouse1);

        em.flush();
        em.close();
        tm.commit();
        emf.close();
*/


        testData data = new testData();
        data.createTestData();

        System.out.print("Ende");
    }
}


