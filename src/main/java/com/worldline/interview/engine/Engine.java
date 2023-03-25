package com.worldline.interview.engine;

import com.worldline.interview.enums.Fuel;
import com.worldline.interview.model.ModelEngine;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode
public class Engine implements EngineInterface<Fuel> {

    private boolean running;
    private int fuelLevel;
    private Fuel requiredFuelType;
    private Fuel fuelType;
    private ModelEngine<Fuel> modelEngine;

    @Override
    public String toString() {
        return "{" +
            " running='" + isRunning() + "'" +
            ", fuelLevel='" + getFuelLevel() + "'" +
            ", requiredFuelType='" + getRequiredFuelType() + "'" +
            ", fuelType='" + getFuelType() + "'" +
            "}";
    }

    public Engine(Fuel requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        this.running = false;
        this.fuelLevel = 0;

        var cs = requiredFuelType.getClass();
        this.modelEngine = new ModelEngine<>(cs.getName(),requiredFuelType);
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(Fuel fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }
    
}
