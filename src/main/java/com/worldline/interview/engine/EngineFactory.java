package com.worldline.interview.engine;

import com.worldline.interview.enums.Fuel;
import com.worldline.interview.enums.FuelCombustionType;
import com.worldline.interview.enums.FuelSteamType;
import com.worldline.interview.model.CombustionModel;
import com.worldline.interview.model.ModelEngine;
import com.worldline.interview.model.SteamModel;

import lombok.Data;

@Data
public class EngineFactory<T> {

    private ModelEngine<?> engineModel;
    private EngineConcrete<?> engine;

    public EngineFactory() {
        new Exception("You need to choose type and fuel type of engine!");
    }

    public EngineFactory(String typeEngine) {
        new Exception("You need to choose fuel type for engine you choose!");
    }

    public EngineFactory(String typeEngine, T typeFuel) {

        if ("".equals(typeEngine) && !(typeFuel instanceof Fuel)) {
            return;
        }

        if (typeEngine == "combustion") {
            FuelCombustionType combustFuel = (FuelCombustionType) typeFuel;
            engineModel = new CombustionModel(combustFuel);
        } else if (typeEngine == "steam") {
            FuelSteamType combustFuel = (FuelSteamType) typeFuel;
            engineModel = new SteamModel(combustFuel);
        }

        createEngine(engineModel);
    }

    private void createEngine(ModelEngine<?> engineModel) {

        this.engine = new EngineConcrete<>(engineModel.getFuelType());
        
    }

}
