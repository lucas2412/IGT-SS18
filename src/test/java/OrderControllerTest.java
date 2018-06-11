import Controller.CustomerController;
import Controller.NewOrderController;
import Controller.OrderController;
import model.Customer;
import model.Order2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.testData;

import javax.transaction.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertNotNull;

public class OrderControllerTest {
    @BeforeAll
    public static void setUp() throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        testData.createTestData();

    }
    @Test
    public void createOrder(){
        OrderController orderController = new OrderController();
        CustomerController customerController = new CustomerController();
        NewOrderController newOrderController = new NewOrderController();

        Customer customer = new Customer();
        customer.setC_STADT("Mannheim");
        customer.setC_PLZ("68199");
        customer.setC_STRASSE("Paul-Wittsack-Straße 10");
        customer.setC_TELEFONNUMMER("0723923194");
        customerController.create(customer);

        Order2 order =orderController.createOrder(customer.getC_ID(), 10);
    //    NewOrder newOrder = newOrderController.getNewOrder(order.getO_ID());

        assertNotNull(customer.getC_D_ID());
        assertEquals(order.getO_C_ID(), customer.getC_ID());
        assertEquals(order.getO_OL_CNT(),(Integer) 10);
     //   assertEquals(newOrder.getNO_O_ID(),order.getO_ID());
    }

}
