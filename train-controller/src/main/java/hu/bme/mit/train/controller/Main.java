package hu.bme.mit.train.controller;

public class Main {
    public static void main (String[] args){

        System.out.println("Welcome to the epic train!");
        TrainControllerImpl TrainControl = new TrainControllerImpl();
        TrainControl.setSpeedLimit(222);
    }


}
