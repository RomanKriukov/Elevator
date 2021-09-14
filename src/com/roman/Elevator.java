package com.roman;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int maxCapacity = 5;
    private int thisStorey;
    private int targetStorey;
    private List<Passenger> elevatorPassengers;
    private boolean directionIsUp;
    private boolean directionIsDown;

    public Elevator() {
        this.elevatorPassengers = new ArrayList<>();
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

    public List<Passenger> getElevatorPassengers() {
        return elevatorPassengers;
    }

    public void setElevatorPassengers(List<Passenger> elevatorPassengers) {
        this.elevatorPassengers = elevatorPassengers;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
