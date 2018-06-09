package test;

import Controller.WarehouseController;
import model.Warehouse;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseTest {

    WarehouseController warehouseController = new WarehouseController();

    @Test
    public void createWarehouseTest(){
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setW_ID(4);
        warehouse1.setW_NAME("Warehouse1");
        warehouse1.setW_PLZ("68723");
        warehouse1.setW_STADT("Schwetzingen");
        warehouse1.setW_STRASSE("Ostpreußenring 45");

        warehouseController.createWarehouse(warehouse1);
        Warehouse newHouse = warehouseController.getWarehouse(4);

        assertEquals(warehouse1.getW_ID() , newHouse.getW_ID() );
    }

}

