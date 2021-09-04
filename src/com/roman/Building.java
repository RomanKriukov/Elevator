package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Building {
    static int numberOfStoreys;
    private List<Storey> storeys;
    private List<Passenger> passengersOfThisStorey;
    private Elevator elevator;

    public Building() {
        numberOfStoreys = 5 + (int)(Math.random() * 16);
        this.storeys = new ArrayList<>();
        for(int i = 1;i <= numberOfStoreys;i++){
            storeys.add(new Storey(i));
        }
        elevator = new Elevator();
        elevator.setThisStorey(1);
        elevator.setTargetStorey(1);
        elevator.setDirectionIsUp(true);
        elevator.setDirectionIsDown(false);
    }

    public void movementElevator(){
        
    }

    public void operationElevator(boolean direction){
        passengersOfThisStorey = storeys.get(elevator.getThisStorey() - 1).getPassengers();

        for(int i = 0;i < passengersOfThisStorey.size();i++){
            if(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getIsUp() == direction && elevator.getElevatorPassengers().size() < elevator.getMaxCapacity()){
                
                elevator.getElevatorPassengers().add(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i));
                storeys.get(elevator.getThisStorey() - 1).getPassengers().remove(i);
                i--;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Storey> getStoreys() {
        return storeys;
    }
}
