package com.worldline.interview.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.fuel.FuelSteamType;

public class WidgetMachineTest {
    
    private  Engine engine;

    @BeforeEach
    void init(){
        engine = new Engine(FuelSteamType.WOOD);
    }

    @Test
    void testProduceWidgetsWithFuel(){
        engine.fill(FuelSteamType.WOOD, 100);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        double cost1 = widgetMachine.produceWidgets(1);
        double cost2 = widgetMachine.produceWidgets(2);
        double cost3 = widgetMachine.produceWidgets(3);
        double cost4 = widgetMachine.produceWidgets(5);
        assertEquals(5.65, cost1);
        assertEquals(5.65, cost2);
        assertNotEquals(5.65, cost3);
        assertNotEquals(5.65, cost4);
    }

    @Test
    void testProduceWidgetsWithFuelEmpty(){
        engine.fill(FuelSteamType.WOOD, 0);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        Exception exception = assertThrows(IllegalStateException.class,
                () -> widgetMachine.produceWidgets(1),
                "Fail Coz This engine is DIESEL cannot start with PETROL fuel");

        assertSame("Not able to start engine.", exception.getMessage());
    }
}
