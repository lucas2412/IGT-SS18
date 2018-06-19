package tools;

import Controller.*;
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

    public static void createTestData() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        WarehouseController warehouseController = new WarehouseController();
        DistrictController districtController = new DistrictController();
        CustomerController customerController = new CustomerController();
        ItemController itemController = new ItemController();
        OrderController orderController = new OrderController();
        OrderLineController orderLineController = new OrderLineController();
        NewOrderController newOrderController = new NewOrderController();
        StockController stockController = new StockController();



        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        Customer customer1 = new Customer();
        List<Customer> customerList = new ArrayList();
        List<District> districtList = new ArrayList();
        List<Stock> stockList = new ArrayList();
        List<OrderLine> orderLineList = new ArrayList();

        Warehouse warehouse1 = new Warehouse();


        Stock stock1 = new Stock();


        Item item1 = new Item();
        OrderLine orderLine1 = new OrderLine();
        NewOrder newOrder = new NewOrder();

        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STRASSE("Ostpreußenring 45");
        warehouse1.setDistrictList(districtList);
        warehouse1.setStockList(stockList);
        warehouse1 = warehouseController.createWarehouse(warehouse1);
        System.out.println(warehouse1.getW_ID());

        District district1 = new District();
        district1.setD_NAME("District1");
        district1.setD_PLZ("68723");
        district1.setD_STADT("Schwetzingen");
        district1.setD_STRASSE("Mannheimer Straße 2");
        district1.setD_W_ID(warehouse1.getW_ID());
        district1.setDistrictWarehouse(warehouse1);
        districtList.add(district1);
        district1.setCustomerList(customerList);
        district1 = districtController.createDistrict(district1);

        District district2 = new District();
        district2.setD_NAME("District2");
        district2.setD_PLZ("12345");
        district2.setD_STADT("Mannheim");
        district2.setD_STRASSE("Teststraße 2");
        district2.setD_W_ID(warehouse1.getW_ID());
        district2.setDistrictWarehouse(warehouse1);
        districtList.add(district2);
        district2.setCustomerList(customerList);
        district2 = districtController.createDistrict(district2);

        District district3 = new District();
        district3.setD_NAME("District3");
        district3.setD_PLZ("12323");
        district3.setD_STADT("Heidelberg");
        district3.setD_STRASSE("adsasd 12");
        district3.setD_W_ID(warehouse1.getW_ID());
        district3.setDistrictWarehouse(warehouse1);
        districtList.add(district3);
        district3.setCustomerList(customerList);
        district3 = districtController.createDistrict(district3);

        District district4 = new District();
        district4.setD_NAME("District4");
        district4.setD_PLZ("61352");
        district4.setD_STADT("Speyer");
        district4.setD_STRASSE("ksakdsd Straße 14");
        district4.setD_W_ID(warehouse1.getW_ID());
        district4.setDistrictWarehouse(warehouse1);
        districtList.add(district4);
        district4.setCustomerList(customerList);
        district4 = districtController.createDistrict(district4);

        District district5 = new District();
        district5.setD_NAME("District5");
        district5.setD_PLZ("12412");
        district5.setD_STADT("Berlin");
        district5.setD_STRASSE("Berliner Straße 2");
        district5.setD_W_ID(warehouse1.getW_ID());
        district5.setDistrictWarehouse(warehouse1);
        districtList.add(district5);
        district5.setCustomerList(customerList);
        district5 = districtController.createDistrict(district5);

        District district6 = new District();
        district6.setD_NAME("District6");
        district6.setD_PLZ("324234");
        district6.setD_STADT("Schwetzingen");
        district6.setD_STRASSE("Mannheimer Straße 2");
        district6.setD_W_ID(warehouse1.getW_ID());
        district6.setDistrictWarehouse(warehouse1);
        districtList.add(district6);
        district6.setCustomerList(customerList);
        district6 = districtController.createDistrict(district6);

        District district7 = new District();
        district7.setD_NAME("District7");
        district7.setD_PLZ("68723");
        district7.setD_STADT("Schwetzingen");
        district7.setD_STRASSE("ewewe Straße 2");
        district7.setD_W_ID(warehouse1.getW_ID());
        district7.setDistrictWarehouse(warehouse1);
        districtList.add(district1);
        district7.setCustomerList(customerList);
        district7 = districtController.createDistrict(district7);

        District district8 = new District();
        district8.setD_NAME("District8");
        district8.setD_PLZ("68723");
        district8.setD_STADT("Hamburg  ");
        district8.setD_STRASSE("adsdds Straße 1232");
        district8.setD_W_ID(warehouse1.getW_ID());
        district8.setDistrictWarehouse(warehouse1);
        districtList.add(district8);
        district8.setCustomerList(customerList);
        district8 = districtController.createDistrict(district8);

        District district9 = new District();
        district9.setD_NAME("District9");
        district9.setD_PLZ("68723");
        district9.setD_STADT("Frankfurt");
        district9.setD_STRASSE("Mannheimer Straße 2");
        district9.setD_W_ID(warehouse1.getW_ID());
        district9.setDistrictWarehouse(warehouse1);
        districtList.add(district9);
        district9.setCustomerList(customerList);
        district9 = districtController.createDistrict(district9);

        District district10 = new District();
        district10.setD_NAME("District10");
        district10.setD_PLZ("68723");
        district10.setD_STADT("Schwetzingen");
        district10.setD_STRASSE("Mannheimer Straße 2");
        district10.setD_W_ID(warehouse1.getW_ID());
        district10.setDistrictWarehouse(warehouse1);
        districtList.add(district1);
        district10.setCustomerList(customerList);
        district10 = districtController.createDistrict(district10);


        customer1.setC_D_ID(district1.getD_ID());
        customer1.setC_PLZ("68723");
        customer1.setC_STADT("Schwetzingen");
        customer1.setC_STRASSE("test 23");
        customer1.setC_TELEFONNUMMER("06202213213");
        customer1.setCustomerDistrict(district1);
        customerList.add(customer1);
        customer1 = customerController.createCustomer(customer1);

        item1.setI_NAME("item 1");
        item1.setI_PRICE(29.99);
        item1.setStockList(stockList);
        item1.setOrderlineList(orderLineList);
        item1 = itemController.createItem(item1);

        Item item2 = new Item();
        item2.setI_NAME("item 2");
        item2.setI_PRICE(55.55);
        item2.setStockList(stockList);
        item2.setOrderlineList(orderLineList);
        item2 = itemController.createItem(item2);

        Item item3 = new Item();
        item3.setI_NAME("item 3");
        item3.setI_PRICE(99.99);
        item3.setStockList(stockList);
        item3.setOrderlineList(orderLineList);
        item3 = itemController.createItem(item3);


        stock1.setS_W_ID(warehouse1.getW_ID());
        stock1.setS_I_ID(item1.getI_ID());
        stock1.setS_DIST_01(district1.getD_NAME());
        stock1.setS_DIST_02(district2.getD_NAME());
        stock1.setS_DIST_03(district3.getD_NAME());
        stock1.setS_DIST_04(district4.getD_NAME());
        stock1.setS_DIST_05(district5.getD_NAME());
        stock1.setS_DIST_06(district6.getD_NAME());
        stock1.setS_DIST_07(district7.getD_NAME());
        stock1.setS_DIST_08(district8.getD_NAME());
        stock1.setS_DIST_09(district9.getD_NAME());
        stock1.setS_DIST_10(district10.getD_NAME());
        stock1.setS_QUANTITY(20);
        stockList.add(stock1);
        stock1 =  stockController.createStock(stock1);

        Order2 order2 = new Order2();
        order2.setO_C_ID(customer1.getC_ID());
        order2.setO_OL_CNT(4);
        order2.setCustomer(customer1);
        order2.setOrderLines(new ArrayList<OrderLine>());
        order2 = orderController.createOrder(customer1.getC_ID(), 4);


        orderLine1.setOL_AMOUNT(3);
        orderLine1.setOL_O_ID(order2.getO_ID());
        orderLine1.setOL_Order(order2);
        orderLine1.setOrderlineItem(item1);
        orderLine1.setOL_I_ID(item1.getI_ID());
        orderLineList.add(orderLine1);
        orderLineController.createOrderLine(5, order2.getO_ID(), item1.getI_ID());

    }

}
