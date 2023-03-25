package com.worldline.interview.engine;

public interface EngineInterface<Fuel> {

    public void start();

    public void stop();

    public boolean isRunning();

    public void fill(Fuel fuelType,int fuelLevel);

}
