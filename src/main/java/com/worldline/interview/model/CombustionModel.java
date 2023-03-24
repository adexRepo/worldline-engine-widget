package com.worldline.interview.model;

import com.worldline.interview.enums.FuelCombustionType;

public class CombustionModel extends ModelEngine<FuelCombustionType> {

    public CombustionModel(FuelCombustionType typeFuel) {

        if (typeFuel == FuelCombustionType.PETROL) {
            super.setCost(9);
        } else if (typeFuel == FuelCombustionType.DIESEL) {
            super.setCost(12);
        }

        super.setFuelType(typeFuel);
        super.setBatchSize(8);
    }

}
