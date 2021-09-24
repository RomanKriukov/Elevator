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
        directionOfTraffic();       // вызов метода выбора этажа назначения для пассажира
    }

    private void directionOfTraffic(){  // метод выбора этажа назначения
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

    public int getTargetStorey() {
        return targetStorey;
    }

    public void setThisStorey(int thisStorey) {
        this.thisStorey = thisStorey;
        directionOfTraffic();
    }

    @Override
    public String toString(){
        String str = " ";
        if(this.id < 10){
            str += "  ";
        }
        else if(this.id > 9 && this.id < 100){
            str += " ";
        }
        return str + this.id;
    }

    public boolean getIsUp() {
        return this.isUp;
    }
}
