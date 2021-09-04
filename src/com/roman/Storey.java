package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Storey {

    private int numberStorey;

    private boolean buttonUp;               // приоритет направления
    private boolean buttonDown;             // большинства

    private List<Passenger> passengers;     // Список пассажиров
    private int numberOfPassengers;

    public Storey(int numberStorey) {
        this.numberStorey = numberStorey;
        this.numberOfPassengers = (int)(Math.random() * 11);
        if(this.numberOfPassengers > 0){
            createPassengers();
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getNumberStorey() {
        return numberStorey;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    private void createPassengers(){
        passengers = new ArrayList<>();
        for(int i = 0;i < this.numberOfPassengers;i++){
            Main.countPassengers++;
            passengers.add(new Passenger(Main.countPassengers, this.numberStorey));
        }
    }
}
