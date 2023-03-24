package com.worldline.interview.model;

import com.worldline.interview.enums.FuelSteamType;

public class SteamModel extends ModelEngine<FuelSteamType>{

    public SteamModel(FuelSteamType typeFuel) {
        if (typeFuel == FuelSteamType.COAL) {
            super.setCost(4.35);
        } else if (typeFuel == FuelSteamType.WOOD) {
            super.setCost(5.65);
        }

        super.setFuelType(typeFuel);
        super.setBatchSize(2);
    }

}
