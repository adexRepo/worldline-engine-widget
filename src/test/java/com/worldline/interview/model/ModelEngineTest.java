package com.worldline.interview.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.worldline.interview.fuel.Fuel;
import com.worldline.interview.fuel.FuelSteamType;

public class ModelEngineTest {
    
    public ModelEngine<Fuel> modelEngine;

    @BeforeEach
    void init(){

        // var combustionFuelName = FuelCombustionType.DIESEL.getClass().getName();
        var SteamFuel = FuelSteamType.COAL.getClass();
        this.modelEngine = new ModelEngine<>(SteamFuel.getName(), FuelSteamType.COAL );
    }

    @Test
    void testModelEngineTestFuel(){
        assertNotNull(modelEngine);
        assertEquals(2,modelEngine.getBatchSize());
        assertEquals(4.35,modelEngine.getCost());
    }

}
