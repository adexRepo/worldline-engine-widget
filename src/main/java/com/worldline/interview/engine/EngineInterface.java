package com.worldline.interview.engine;

public interface EngineInterface<T> {

    public void start();

    public void stop();

    public boolean isRunning();

    public void fill(T fuelType, int fuelLevel);

    public T getFuelType();

}
