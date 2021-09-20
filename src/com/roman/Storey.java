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
        this.passengers = new ArrayList<>();
        this.numberStorey = numberStorey;
        this.numberOfPassengers = (int)(Math.random() * 11);
        if(this.numberOfPassengers > 0){
            createPassengers();
        }
    }

    private void clickButton(){
        int up = 0;
        int down = 0;
        for(int i = 0;i < this.passengers.size();i++){
            if(this.passengers.get(i).getIsUp()){
                up++;
            }
            else {
                down++;
            }
        }
        if(up > 0){
            this.buttonUp = true;
        }
        else{
            this.buttonUp = false;
        }
        if(down > 0){
            this.buttonDown = true;
        }
        else{
            this.buttonDown = false;
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
        clickButton();
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

    public boolean isButtonUp() {
        return buttonUp;
    }

    public boolean isButtonDown() {
        return buttonDown;
    }

    private void createPassengers(){

        for(int i = 0;i < this.numberOfPassengers;i++){
            Main.countPassengers++;
            passengers.add(new Passenger(Main.countPassengers, this.numberStorey));
        }
        clickButton();
    }
}
