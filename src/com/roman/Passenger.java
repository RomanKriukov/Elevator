package com.roman;

public class Passenger {
    private int id;
    private int thisStorey;     // Текущий этаж
    private int targetStorey;   // Этаж назначения

    private boolean isUp;       // Направление
    private boolean isDown;     // движения пассажира

    public Passenger(int id, int thisStorey) {
        this.id = id;
        this.thisStorey = thisStorey;

        directionOfTraffic();
    }



    private void directionOfTraffic(){

        do{
            this.targetStorey = 1 + (int)(Math.random() * Building.numberOfStoreys);
        }while (this.thisStorey == this.targetStorey);

        if(this.targetStorey > this.thisStorey){
            this.isUp = true;
            this.isDown = false;
        }
        else{
            this.isUp = false;
            this.isDown = true;
        }
    }

    public int getId() {
        return id;
    }

    public int getTargetStorey() {
        return targetStorey;
    }

    public int getThisStorey() {
        return thisStorey;
    }

    public void setThisStorey(int thisStorey) {
        this.thisStorey = thisStorey;
        directionOfTraffic();
    }

    public boolean getIsUp() {
        return this.isUp;
    }

    public boolean getIsDown(){
        return this.isDown;
    }
}
