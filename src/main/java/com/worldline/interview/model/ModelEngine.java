package com.worldline.interview.model;

import com.worldline.interview.enums.FuelCombustionType;
import com.worldline.interview.enums.FuelSteamType;

import lombok.Data;

@Data
public class ModelEngine<Fuel> {

    private int batchSize;
    private double cost;
    private Fuel requiredFuelType;

    public ModelEngine(String type, Fuel fuelType) {
        this.requiredFuelType = fuelType;

        if (type.contains("FuelCombustionType")) {
            this.batchSize = 8;
            if (fuelType == FuelCombustionType.PETROL) {
                this.cost = 9;
            } else if (fuelType == FuelCombustionType.DIESEL) {
                this.cost = 12;
            }
        } else if (type.contains("FuelSteamType")) {
            this.batchSize = 2;
            if (fuelType == FuelSteamType.COAL) {
                this.cost = 9;
            } else if (fuelType == FuelSteamType.WOOD) {
                this.cost = 12;
            }
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

}
