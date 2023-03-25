package com.worldline.interview.widget;

import com.worldline.interview.engine.Engine;

public class WidgetMachine {

    public Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        System.out.println("cost: " + cost);
        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = engine.getModelEngine().getCost();

        while (batch < quantity) {
            batch = batch + engine.getModelEngine().getBatchSize();
            batchCount++;
        }

        double batchCountDbl = batchCount;
        return batchCountDbl * costPerBatch;
    }

}
