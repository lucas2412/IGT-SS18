package tools;

import Controller.CustomerController;
import Controller.WarehouseController;
import model.Order;
import model.Order2;
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

        Order2 order2 = new Order2();
        order2.setO_ID(1);

        tm.begin();
        EntityManager em = emf.createEntityManager();

        em.persist(order2);

        em.flush();
        em.close();
        tm.commit();
        emf.close();


*/
        testData data = new testData();
        data.createTestData();

     //   CustomerController controller = new CustomerController();
       // controller.create("1","3","68723", "20", 1);

        System.out.print("Ende");
    }
}


