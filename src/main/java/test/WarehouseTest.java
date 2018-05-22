package test;

import Controller.WarehouseController;
import model.Warehouse;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseTest {

    WarehouseController warehouseController = new WarehouseController();

    @Test
    public void createWarehouseTest(){
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setW_ID(13124);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STEUERSATZ(0.16);
        warehouse1.setW_STRAßE("Ostpreußenring 45");
        warehouse1.setW_YTD("aad");

        warehouseController.createWarehouse(warehouse1);
        Warehouse newHouse = warehouseController.getWarehouse(1);

        assertEquals(warehouse1.getW_ID() , newHouse.getW_ID() );
    }

}

