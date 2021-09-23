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
    }

    private void view(){
        String str = "";
        for(int i = 0;i < 20;i++){
            str += "\n";
        }
        str += toString();
        System.out.println(str);
    }

    public void movementElevator(){

        while (true){
            view();
            if(elevator.getElevatorPassengers().size() != 0 && elevator.getThisStorey() == elevator.getFirstTargetStorey()){
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
            if(elevator.getDirectionIsUp() &&
                    storeys.get(elevator.getThisStorey() - 1).isButtonUp() == elevator.getDirectionIsUp() &&
                    elevator.getElevatorPassengers().size() != elevator.getMaxCapacity() ||
                    elevator.getDirectionIsDown() &&
                    storeys.get(elevator.getThisStorey() - 1).isButtonDown() == elevator.getDirectionIsDown() &&
                    elevator.getElevatorPassengers().size() != elevator.getMaxCapacity()){

                loadingElevator(elevator.getDirectionIsUp());
            }
            if(elevator.getDirectionIsUp()){
                elevator.setThisStorey(elevator.getThisStorey() + 1);
            }
            else if(!elevator.getDirectionIsUp()){
                elevator.setThisStorey(elevator.getThisStorey() - 1);
            }

            try {
                Thread.sleep(2000);
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
        numberThisStorey = elevator.getThisStorey() - 1;
        List<Passenger> elevatorP = elevator.getElevatorPassengers();
        List<Passenger> storeyP = storeys.get(numberThisStorey).getPassengers();
        for(int i = 0;i < elevatorP.size();i++){
            if(elevatorP.get(i).getTargetStorey() == elevator.getThisStorey()){
                storeyP.add(elevatorP.get(i));
                elevatorP.remove(i);
                storeyP.get(storeyP.size() - 1).setThisStorey(elevator.getThisStorey());
                i--;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view();
            }
        }
        elevator.setElevatorPassengers(elevatorP);
        storeys.get(numberThisStorey).setPassengers(storeyP);
    }

    private void loadingElevator(boolean direction){
        numberThisStorey = elevator.getThisStorey() - 1;
        List<Passenger> elevatorP = elevator.getElevatorPassengers();
        List<Passenger> storeyP = storeys.get(numberThisStorey).getPassengers();
        int count = 0;
        while (elevatorP.size() < elevator.getMaxCapacity() && count < storeyP.size()){
            if(storeyP.get(count).getIsUp() == direction){
                elevatorP.add(storeyP.get(count));
                storeyP.remove(count);
                count--;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view();
            }
            count++;
        }
        elevator.setElevatorPassengers(elevatorP);
        storeys.get(numberThisStorey).setPassengers(storeyP);
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = numberOfStoreys - 1;i >= 0;i--){
            str += storeys.get(i).toString();
            if(elevator.getThisStorey() - 1 == i){
                String direction;
                if(elevator.getDirectionIsUp()){
                    direction = "^";
                }else {
                    direction = "V";
                }
                str += direction;
                str += elevator.toString();
                str += direction;

            }
            else {
                str += "                        ";
            }
            str += "|";
            for(Passenger p : storeys.get(i).getPassengers()){
                str += p.toString();
            }
            str += "\n";
        }
        return str;
    }
}
