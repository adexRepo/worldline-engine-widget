package com.worldline.interview.model;

import com.worldline.interview.fuels.FuelSteamType;

import lombok.Data;

@Data
public class SteamModel {

    public final int batchSize = 8;
    public double cost;

    public SteamModel(FuelSteamType typeFuel) {
        if (typeFuel == FuelSteamType.COAL) {
            this.cost = 4.35;
        } else if (typeFuel == FuelSteamType.WOOD) {
            this.cost = 5.65;
        }    
    }

}
