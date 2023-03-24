package com.worldline.interview.widget;

import com.worldline.interview.engine.EngineConcrete;
import com.worldline.interview.model.ModelEngine;

public class WidgetMachine {

    private ModelEngine<?> model;
    private EngineConcrete<?> engine;

    public WidgetMachine(ModelEngine<?> model, EngineConcrete<?> engine) {
        this.model = model;
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = model.getCost();

        while (batch < quantity) {
            batch = batch + model.getBatchSize();
            batchCount++;
        }

        double  batchCountDbl = batchCount;
        return batchCountDbl * costPerBatch;
    }



}
