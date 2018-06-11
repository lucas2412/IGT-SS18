import Controller.CustomerController;
import model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.testData;

import javax.transaction.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CustomerControllerTest {

    @BeforeAll
    public static void setUp() throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        testData.createTestData();

    }


    @Test
    public void createCustomerTest(){
        CustomerController customerController = new CustomerController();

        Customer customer = new Customer();

        customer.setC_STADT("Mannheim");
        customer.setC_PLZ("68199");
        customer.setC_STRASSE("Paul-Wittsack-Straße 10");
        customer.setC_TELEFONNUMMER("0723923194");

        customerController.create(customer);

        Customer customernew = customerController.getCustomer(customer.getC_ID());

        assertEquals(customer.getC_ID() ,customernew.getC_ID());
        assertNotNull(customer.getC_D_ID());
    }

    @Test
    public void updateCustomerTest(){
        CustomerController customerController = new CustomerController();
        Customer customer = new Customer();

        customer.setC_STADT("Mannheim");
        customer.setC_PLZ("68199");
        customer.setC_STRASSE("Paul-Wittsack-Straße 10");
        customer.setC_TELEFONNUMMER("0723923194");
        customerController.create(customer);

        customer.setC_STADT("Schwetzingen");
        customer.setC_STRASSE("Ostpreussenring");

        customerController.updateCustomer(customer.getC_ID(), customer);

        Customer customernew = customerController.getCustomer(customer.getC_ID());

        assertEquals(customernew.getC_STADT() ,"Schwetzingen");
        assertEquals(customernew.getC_STRASSE() ,"Ostpreussenring");
    }

    @Test
    public void deleteCustomerTest(){
        CustomerController customerController = new CustomerController();
        Customer customer = new Customer();

        customer.setC_STADT("Mannheim");
        customer.setC_PLZ("68199");
        customer.setC_STRASSE("Paul-Wittsack-Straße 10");
        customer.setC_TELEFONNUMMER("0723923194");
        customerController.create(customer);

        boolean a = customerController.deleteCustomer(customer.getC_ID());


       // Assertions.assertThrows(IndexOutOfBoundsException(););

        assertEquals(a ,true);
    }


}
