package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.fuel.FuelCombustionType;
// import com.worldline.interview.enums.FuelSteamType;
import com.worldline.interview.widget.WidgetMachine;

public class AppWidgetMachine 
{
    public static void main( String[] args ) throws ClassNotFoundException
    {

        // Test 1
        // Engine engine = new Engine(FuelSteamType.COAL);
        // engine.fill(FuelSteamType.COAL, 60);

        // Test 2
        Engine engine = new Engine(FuelCombustionType.DIESEL);
        engine.fill(FuelCombustionType.DIESEL, 60);
        
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        widgetMachine.produceWidgets(4);
    }
}
