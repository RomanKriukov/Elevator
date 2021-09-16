package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Building {
    static int numberOfStoreys;
    private List<Storey> storeys;
    private Elevator elevator;
    private int numberThisStorey;

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
        numberThisStorey = elevator.getThisStorey() - 1;
        System.out.println(storeys.size());
        System.out.println(numberOfStoreys);
    }

    public void movementElevator(){
        while (true){

            System.out.print(elevator.getDirectionIsUp());
            System.out.print(storeys.get(elevator.getThisStorey() - 1).getNumberStorey() + "  ");
            System.out.print(elevator.getThisStorey() + " | " + storeys.get(elevator.getThisStorey() - 1).getPassengers().size() + "| ");

            if(elevator.getElevatorPassengers().size() != 0){
                unloadingElevator();
            }
            if(elevator.getElevatorPassengers().size() == 0){
                if(elevator.getThisStorey() == 1){
                    elevator.setDirectionIsUp(true);
                    elevator.setDirectionIsDown(false);
                }
                else if(elevator.getThisStorey() == storeys.size()){
                    elevator.setDirectionIsUp(false);
                    elevator.setDirectionIsDown(true);
                }else {
                    choiseOfDirection();
                }
            }
            if(storeys.get(numberThisStorey).getPassengers().size() != 0){
                loadingElevator(elevator.getDirectionIsUp());
            }
            if(elevator.getDirectionIsUp()){
                elevator.setThisStorey(elevator.getThisStorey() + 1);
            }
            else if(!elevator.getDirectionIsUp()){
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

    public void unloadingElevator(){
        numberThisStorey = elevator.getThisStorey() - 1;
        List<Passenger> elevatorP = elevator.getElevatorPassengers();
        List<Passenger> storeyP = storeys.get(numberThisStorey).getPassengers();
        for(int i = 0;i < elevatorP.size();i++){
            if(elevatorP.get(i).getTargetStorey() == elevator.getThisStorey()){
                storeyP.add(elevatorP.get(i));
                elevatorP.remove(i);
                storeyP.get(storeyP.size() - 1).setThisStorey(elevator.getThisStorey());
                i--;
            }
        }
        elevator.setElevatorPassengers(elevatorP);
        storeys.get(numberThisStorey).setPassengers(storeyP);
    }

    public void loadingElevator2(boolean direction){
        numberThisStorey = elevator.getThisStorey() - 1;
        List<Passenger> elevatorP = elevator.getElevatorPassengers();
        List<Passenger> storeyP = storeys.get(numberThisStorey).getPassengers();

    }

    public void loadingElevator(boolean direction){

        if(storeys.get(elevator.getThisStorey() - 1).getPassengers() == null){}
        else {
            for (int i = 0; i < storeys.get(elevator.getThisStorey() - 1).getPassengers().size(); i++) {
                if (storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getIsUp() == direction && elevator.getElevatorPassengers().size() < elevator.getMaxCapacity()) {

                    elevator.getElevatorPassengers().add(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i));

                    if (direction && elevator.getTargetStorey() < storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey()) {
                        elevator.setTargetStorey(storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey());
                    } else if (!direction && elevator.getTargetStorey() > storeys.get(elevator.getThisStorey() - 1).getPassengers().get(i).getTargetStorey()) {
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
    }

    public List<Storey> getStoreys() {
        return storeys;
    }
}
