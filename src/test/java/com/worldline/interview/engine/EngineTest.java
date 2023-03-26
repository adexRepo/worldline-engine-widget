package com.worldline.interview.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import com.worldline.interview.fuel.FuelCombustionType;

public class EngineTest {

    private Engine engine;

    @BeforeEach
    public void init() {
        this.engine = new Engine(FuelCombustionType.DIESEL);
    }

    @Test
    void testConstructorEngine() {

        assertEquals(false, engine.isRunning());
        assertEquals(0, engine.getFuelLevel());
        assertEquals(null, engine.getFuelType());
        assertEquals(FuelCombustionType.DIESEL, engine.getRequiredFuelType());
        assertNotNull(engine.getModelEngine());

    }

    @Test
    void testFillFuelEngine() {
        engine.fill(FuelCombustionType.DIESEL, 70);

        // correct scenario
        assertEquals(false, engine.isRunning());
        assertEquals(70, engine.getFuelLevel());
        assertEquals(FuelCombustionType.DIESEL, engine.getFuelType());
        assertEquals(FuelCombustionType.DIESEL, engine.getRequiredFuelType());
        assertNotNull(engine.getModelEngine());
        assertNotSame(FuelCombustionType.PETROL, engine.getFuelType());

    }

    @RepeatedTest(value = 3)
    void testStartStop(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            engine.fill(FuelCombustionType.DIESEL, 70);

            engine.start();
            assertTrue(engine.isRunning());

            engine.stop();
            assertFalse(engine.isRunning());

        } else if (repetitionInfo.getCurrentRepetition() == 2){

            engine.fill(FuelCombustionType.PETROL, 40);
            Exception exception = assertThrows(IllegalStateException.class,
                    () -> engine.start(),
                    "Fail Coz This engine is DIESEL cannot start with PETROL fuel");

            assertSame("Not able to start engine.", exception.getMessage());
            assertFalse(engine.isRunning());

        }else{

            engine.fill(FuelCombustionType.DIESEL, 0);
            Exception exception = assertThrows(IllegalStateException.class,
            () -> engine.start(),
            "Fuel not enough for start");

            assertSame("Not able to start engine.", exception.getMessage());
            assertFalse(engine.isRunning());

        }

    }

}
