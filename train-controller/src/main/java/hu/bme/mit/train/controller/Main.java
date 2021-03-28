package hu.bme.mit.train.controller;

public class Main {
    public static void main (String[] args){

        System.out.println("Welcome to the epic train!");
        TrainControllerImpl trainControl = new TrainControllerImpl();
        trainControl.setSpeedLimit(222);
    }


}
