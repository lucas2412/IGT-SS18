import Controller.CustomerController;
import Controller.ItemController;
import Controller.OrderController;
import Controller.OrderLineController;
import model.Customer;
import model.Item;
import model.Order2;
import model.OrderLine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.testData;

import javax.transaction.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class OrderLineControllerTest {
    @BeforeAll
    public static void setUp() throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        testData.createTestData();

    }
    @Test
    public void createOrderline(){
        OrderController orderController = new OrderController();
        CustomerController customerController = new CustomerController();
        ItemController itemController = new ItemController();
        OrderLineController orderLineController = new OrderLineController();

        Item item = new Item();
        item.setI_PRICE(99.99);
        item.setI_NAME("Item 1");
        itemController.createItem(item);

        Customer customer = new Customer();
        customer.setC_STADT("Mannheim");
        customer.setC_PLZ("68199");
        customer.setC_STRASSE("Paul-Wittsack-Straße 10");
        customer.setC_TELEFONNUMMER("0723923194");
        customerController.create(customer);

        Order2 order = orderController.createOrder(customer.getC_ID(), 10);

        OrderLine orderLine = orderLineController.createOrderLine(10, order.getO_ID(), item.getI_ID());

        assertNotNull(orderLine.getOL_NUMBER());
        assertNotNull(orderLine.getOL_DELIVERY_D());
        assertEquals(orderLine.getOL_O_ID(), order.getO_ID());
        assertEquals(orderLine.getOL_AMOUNT(), (Integer) 10);




    }
}
