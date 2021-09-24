package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Storey {

    static int countPassengers = 0;
    private int numberStorey;

    private boolean buttonUp;               // кнопки вверх и вниз, приоритет направления
    private boolean buttonDown;             // большинства для выбора направления лифта

    private List<Passenger> passengers;     // Список пассажиров на этаже
    private int numberOfPassengers;         // количество пассажиров

    public Storey(int numberStorey) {
        this.passengers = new ArrayList<>();
        this.numberStorey = numberStorey;
        this.numberOfPassengers = (int)(Math.random() * 11);    // количество создаваемых пассажиров от 0 - 10
        if(this.numberOfPassengers > 0){
            createPassengers();         // вызов метода создания пассажиров на этаже
        }
    }

    private void clickButton(){         // определение количества пассажиров нажавших кнопку вверх или вниз
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

    public boolean isButtonUp() {
        return buttonUp;
    }

    public boolean isButtonDown() {
        return buttonDown;
    }

    private void createPassengers(){        // заполнение этажа пассажирами
        for(int i = 0;i < this.numberOfPassengers;i++){
            countPassengers++;
            passengers.add(new Passenger(countPassengers, this.numberStorey));
        }
        clickButton();
    }

    @Override
    public String toString() {
        String str = " ";
        if(this.numberStorey < 10){
            str += " ";
        }
        return str + this.numberStorey + "|";
    }
}
