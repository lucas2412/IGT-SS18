import Controller.CustomerController;
import Controller.ItemController;
import Controller.NewOrderController;
import Controller.OrderController;
import model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tools.testData;

import javax.transaction.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemControllerTest {

    @BeforeAll
    public static void setUp() throws HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        testData.createTestData();

    }
    @Test
    public void createItem(){
        OrderController orderController = new OrderController();
        CustomerController customerController = new CustomerController();
        NewOrderController newOrderController = new NewOrderController();
        ItemController itemController = new ItemController();

        Item item = new Item();
        item.setI_PRICE(99.99);
        item.setI_NAME("Item 10");
        itemController.createItem(item);


        assertNotNull(item.getI_ID());

    }


    @Test
    public void updateItem(){
        ItemController itemController = new ItemController();

        Item item = new Item();
        item.setI_PRICE(99.99);
        item.setI_NAME("Item 10");
        itemController.createItem(item);

        item.setI_PRICE(55.55);


        item = itemController.updateItem(item.getI_ID(), item);

        assertEquals(item.getI_PRICE(), (Double) 55.55);

    }

    @Test
    public void deleteItem(){
        ItemController itemController = new ItemController();

        Item item = new Item();
        item.setI_PRICE(99.99);
        item.setI_NAME("Item 10");
        itemController.createItem(item);

        boolean a = itemController.deleteItem(item.getI_ID());

        assertEquals(a ,true);

    }
}
