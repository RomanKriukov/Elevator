package com.roman;

import java.util.List;


public class Main {

    static int countPassengers = 0;

    public static void main(String[] args) {
	// write your code here
//        Storey storey = new Storey(3);
//        System.out.println(storey.getNumberStorey());
//        System.out.println(storey.getNumberOfPassengers());
//        System.out.println();
//        List<Passenger> passengers = storey.getPassengers();
//        for(Passenger p : passengers){
//            System.out.print(p.getId() + " ");
//            System.out.print(p.getThisStorey() + " ");
//            System.out.print(p.getTargetStorey() + " ");
//            if(p.getIsUp()){
//                System.out.println("^");
//            }
//            else{
//                System.out.println("v");
//            }
//            System.out.println();
//        }

        Building building = new Building();

//        List<Storey> storeys = building.getStoreys();
//        System.out.println();
//        System.out.println(Building.numberOfStoreys);
//        System.out.println();
//        System.out.println(storeys.get(0).getNumberStorey());
//        for(int i = 0;i < 2;i++){
//            System.out.print(storeys.get(i).getNumberStorey() + "   ");
//            System.out.println(storeys.get(i).getNumberOfPassengers());
//            System.out.println();
//            List<Passenger> passengers = storeys.get(i).getPassengers();
//            if(passengers != null) {
//                for (Passenger p : passengers) {
//                    System.out.print(p.getId() + " ");
//                    System.out.print(p.getThisStorey() + " ");
//                    System.out.print(p.getTargetStorey() + " ");
//                    if (p.getIsUp()) {
//                        System.out.println("^");
//                    } else {
//                        System.out.println("v");
//                    }
//                    System.out.println();
//                }
//            }
//        }

//        storeys.get(0).getPassengers().add(storeys.get(1).getPassengers().get(2));
//        storeys.get(0).setNumberOfPassengers(storeys.get(0).getPassengers().size());
//        storeys.get(1).getPassengers().get(2).setThisStorey(storeys.get(0).getNumberStorey());
//        storeys.get(1).getPassengers().remove(2);
//        storeys.get(1).setNumberOfPassengers(storeys.get(1).getPassengers().size());
//
//        List<Storey> storeys1 = building.getStoreys();
//        System.out.println();
//        System.out.println(Building.numberOfStoreys);
//        System.out.println();
//        for(int i = 0;i < 2;i++){
//            System.out.print(storeys1.get(i).getNumberStorey() + "   ");
//            System.out.println(storeys1.get(i).getNumberOfPassengers());
//            System.out.println();
//            List<Passenger> passengers = storeys1.get(i).getPassengers();
//            if(passengers != null) {
//                for (Passenger p : passengers) {
//                    System.out.print(p.getId() + " ");
//                    System.out.print(p.getThisStorey() + " ");
//                    System.out.print(p.getTargetStorey() + " ");
//                    if (p.getIsUp()) {
//                        System.out.println("^");
//                    } else {
//                        System.out.println("v");
//                    }
//                    System.out.println();
//                }
//            }
//        }

//        for (Storey s : storeys){
//            System.out.print(s.getNumberStorey() + "   ");
//            System.out.print(s.getNumberOfPassengers() + "   ");
//            System.out.println();
//            System.out.println();
//            List<Passenger> passengers = s.getPassengers();
//            if(passengers != null) {
//                for (Passenger p : passengers) {
//                    System.out.print(p.getId() + " ");
//                    System.out.print(p.getThisStorey() + " ");
//                    System.out.print(p.getTargetStorey() + " ");
//                    if (p.getIsUp()) {
//                        System.out.println("^");
//                    } else {
//                        System.out.println("v");
//                    }
//                    System.out.println();
//                }
//            }
//        }
    }
}
