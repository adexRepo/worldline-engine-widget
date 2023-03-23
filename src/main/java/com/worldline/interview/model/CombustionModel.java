package com.worldline.interview.model;

import com.worldline.interview.fuels.FuelCombustionType;

import lombok.Data;

@Data
public class CombustionModel {
    
    public final int batchSize = 2;
    public double cost;

    public CombustionModel(FuelCombustionType typeFuel) {
        if (typeFuel == FuelCombustionType.PETROL) {
            this.cost = 9;
        } else if (typeFuel == FuelCombustionType.DIESEL) {
            this.cost = 12;
        }    
    }

}
