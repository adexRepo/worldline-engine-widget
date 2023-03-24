package com.worldline.interview.model;

import lombok.Data;

@Data
public class ModelEngine<T> {

    private int batchSize;
    private double cost;
    private T fuelType;

}
