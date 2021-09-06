package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Building {
    static int numberOfStoreys;
    private List<Storey> storeys;
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
        while (true){
            System.out.print(storeys.get(elevator.getThisStorey() - 1).getNumberStorey() + "  ");
            System.out.print(elevator.getThisStorey() + "   " + elevator.getElevatorPassengers().size());
            if(elevator.getElevatorPassengers().size() != 0){
                unloadingElevator();
            }
            else if(elevator.getElevatorPassengers().size() == 0){
                choiseOfDirection();
            }
            if(elevator.getDirectionIsUp()){
                loadingElevator(elevator.getDirectionIsUp());
                elevator.setThisStorey(elevator.getThisStorey() + 1);
            }
            else if(!elevator.getDirectionIsUp()){
                loadingElevator(elevator.getDirectionIsUp());
                elevator.setThisStorey(elevator.getThisStorey() - 1);
            }
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void choiseOfDirection(){
        int up = 0;
        int down = 0;
        for(Passenger p : storeys.get(elevator.getThisStorey() - 1).getPassengers()){
            if(p.getIsUp()){
                up++;
            }
            else{
                down++;
            }
        }
        if(up > down){
            elevator.setDirectionIsUp(true);
            elevator.setDirectionIsDown(false);
        }
        else if(up < down){
            elevator.setDirectionIsUp(false);
            elevator.setDirectionIsDown(true);
        }
    }

    private void unloadingElevator(){
        for(int i = 0;i < elevator.getElevatorPassengers().size();i++){
            if(elevator.getElevatorPassengers().get(i).getTargetStorey() == elevator.getThisStorey()){
                elevator.getElevatorPassengers().get(i).setThisStorey(elevator.getThisStorey());
                storeys.get(elevator.getThisStorey() - 1).getPassengers().add(elevator.getElevatorPassengers().get(i));
                elevator.getElevatorPassengers().remove(i);
            }
        }
    }

    private void loadingElevator(boolean direction){

        for(int i = 0;i < storeys.get(elevator.getThisStorey() - 1).getPassengers().size();i++){
            if(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getIsUp() == direction && elevator.getElevatorPassengers().size() < elevator.getMaxCapacity()){
                
                elevator.getElevatorPassengers().add(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i));

                if(direction && elevator.getTargetStorey() < storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey()){
                    elevator.setTargetStorey(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey());
                }
                else if(!direction && elevator.getTargetStorey() > storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey()){
                    elevator.setTargetStorey(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey());
                }

                storeys.get(elevator.getThisStorey() - 1).getPassengers().remove(i);
                i--;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("  " + elevator.getElevatorPassengers().size());
        }
    }

    public List<Storey> getStoreys() {
        return storeys;
    }
}
