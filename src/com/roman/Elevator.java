package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int maxCapacity = 5;
    private int thisStorey;
    private int firstTargetStorey;
    private int targetStorey;
    private List<Passenger> elevatorPassengers;
    private boolean directionIsUp;
    private boolean directionIsDown;

    public Elevator() {
        this.elevatorPassengers = new ArrayList<>();
        this.firstTargetStorey = Building.numberOfStoreys;
    }

    private void firstDestinationStorey(){
        for(int i = 0;i < this.elevatorPassengers.size();i++){
            if(this.directionIsUp && this.elevatorPassengers.get(i).getTargetStorey() < this.firstTargetStorey){
                this.firstTargetStorey = this.elevatorPassengers.get(i).getTargetStorey();
            }
            else if(!this.directionIsUp && this.elevatorPassengers.get(i).getTargetStorey() > this.firstTargetStorey){
                this.firstTargetStorey = this.elevatorPassengers.get(i).getTargetStorey();
            }
        }
    }

    public boolean getDirectionIsUp() {
        return directionIsUp;
    }

    public void setDirectionIsUp(boolean directionIsUp) {
        this.directionIsUp = directionIsUp;
    }

    public boolean getDirectionIsDown() {
        return directionIsDown;
    }

    public void setDirectionIsDown(boolean directionIsDown) {
        this.directionIsDown = directionIsDown;
    }

    public void setThisStorey(int thisStorey) {
        this.thisStorey = thisStorey;
    }

    public int getThisStorey() {
        return thisStorey;
    }

    public void setTargetStorey(int targetStorey) {
        this.targetStorey = targetStorey;
    }

    public int getTargetStorey() {
        return targetStorey;
    }

    public int getFirstTargetStorey() {
        return firstTargetStorey;
    }

    public void setFirstTargetStorey(int firstTargetStorey) {
        this.firstTargetStorey = firstTargetStorey;
    }

    public List<Passenger> getElevatorPassengers() {
        return elevatorPassengers;
    }

    public void setElevatorPassengers(List<Passenger> elevatorPassengers) {
        this.elevatorPassengers = elevatorPassengers;
        firstDestinationStorey();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
