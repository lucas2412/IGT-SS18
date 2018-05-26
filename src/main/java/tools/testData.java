package tools;

import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testData {

    public void createTestData() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {



        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        Customer customer1 = new Customer();
        List<Customer> customerList = new ArrayList();


        History history1 = new History();
        Warehouse warehouse1 = new Warehouse();
        District district1 = new District();

        Stock stock1 = new Stock();
        List<Stock> stockList = new ArrayList();
        stockList.add(stock1);

        Item item1 = new Item();
        OrderLine orderLine1 = new OrderLine();
        Order order1 = new Order();
        NewOrder newOrder = new NewOrder();

        warehouse1.setW_ID(1);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STRAßE("Ostpreußenring 45");

        district1.setD_ID(1);
        district1.setD_NAME("District1");
        district1.setD_PLZ("68723");
        district1.setD_STADT("Schwetzingen");
        district1.setD_STRAßE("Mannheimer Straße 2");
        district1.setD_W_ID(1);


        history1.setH_ID(1);
        history1.setCustomer(customer1);
        history1.setH_AMOUNT(23.9);
        history1.setH_DATE(date);
        history1.setOrderList(new ArrayList<Order>());

        customer1.setC_ID(1);
        customer1.setC_D_ID(1);
        customer1.setC_H_ID(history1.getH_ID());
        customer1.setC_KONTOSTAND(5000.24);
        customer1.setC_PLZ("68723");
        customer1.setC_STADT("Schwetzingen");
        customer1.setC_STRAßE("test 23");
        customer1.setC_TELEFONNUMMER("06202213213");
        customer1.setC_KUNDESEIT(date);
        customer1.setC_RABATT(10.15);
        customer1.setCustomerDistrict(district1);
        customer1.setCustomerHistory(history1);
        customerList.add(customer1);



        stock1.setS_ID(1);
        stock1.setS_W_ID(1);
        stock1.setOL_List(new ArrayList<OrderLine>());
        stock1.setS_DIST_01(district1.getD_NAME());
        stock1.setS_DIST_02("district2");
        stock1.setS_DIST_03("district3");
        stock1.setS_DIST_04("district4");
        stock1.setS_DIST_05("district5");
        stock1.setS_DIST_06("district6");
        stock1.setS_DIST_07("district7");
        stock1.setS_DIST_08("district8");
        stock1.setS_DIST_09("district9");
        stock1.setS_DIST_10("district10");


        stock1.setS_I_ID(1);
        stock1.setS_ORDER_CNT(11);

        item1.setI_ID(1);
        item1.setI_IM_ID(2);
        item1.setI_NAME("item1");
        item1.setI_NAME("name item1");
        item1.setI_PRICE(29.99);
        item1.setStockList(stockList);

        order1.setO_ID(1);
        order1.setO_C_ID(1);
        order1.setO_H_ID(1);
        order1.setO_OL_CNT(10);
        order1.setO_EINGANGSDATUM(date);

        order1.setNewOrder(newOrder);
        order1.setCustomer(customer1);
        order1.setOrderHistory(history1);
        order1.setOrderLines(new ArrayList<OrderLine>());

        orderLine1.setOL_NUMBER(1);
        orderLine1.setOL_AMOUNT(3);
        orderLine1.setOL_DELIVERY_D(date);
        orderLine1.setOL_O_ID(1);
        orderLine1.setOL_Order(order1);
        orderLine1.setOL_QUANTITY(6);
        orderLine1.setOL_Stock(stock1);
        orderLine1.setOL_S_I_ID(1);
        orderLine1.setOL_S_ID(1);



        newOrder.setNO_ID(1);
        newOrder.setNO_O_ID(1);
        newOrder.setNewOrder(order1);


        district1.setCustomerList(customerList);

        if (Config.PERSISTENCE_UNIT_NAME != "MYSQL") {
            //accessing JBoss's Transaction can be done differently but this one works nicely
            TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
            //build the EntityManagerFactory as you would build in in Hibernate ORM
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);


            tm.begin();


            EntityManager em = emf.createEntityManager();

            em.persist(warehouse1);
            em.persist(district1);
            em.persist(history1);
            em.persist(customer1);
            em.persist(item1);
            em.persist(stock1);

            //ab hier gehts nicht mehr (SQL Syntax Fehler ????)
            //  em.persist(order1);
            //   em.persist(newOrder);
            // em.persist(orderLine1);



            em.flush();
            em.close();
            tm.commit();
            emf.close();

        }  else {

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            em.getTransaction().begin();

            em.persist(warehouse1);
            em.persist(district1);
            em.persist(history1);
            em.persist(customer1);
            em.persist(item1);
            em.persist(stock1);

            //ab hier gehts nicht mehr (SQL Syntax Fehler ????)
          //  em.persist(order1);
         //   em.persist(newOrder);
           // em.persist(orderLine1);


            em.getTransaction().commit();


            em.close();
            factory.close();
        }
    }
}
