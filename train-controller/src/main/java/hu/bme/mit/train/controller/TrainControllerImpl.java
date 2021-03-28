package hu.bme.mit.train.controller;

import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl  extends Thread implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Tachograph Tachocounter = new Tachograph();
	private int time=0;
	private Thread thread;


	public TrainControllerImpl(){
		TrainControllerImpl obj = new TrainControllerImpl();
		thread = new Thread();
		this.run();
		}

	public void run(){
		thread.run();
		followSpeed();
		try {
			thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}




	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();

		Tachocounter.record(time,referenceSpeed,step);
		time++;
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}



	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;

	}

	@Override
	public Table<Integer, String, Integer> gettacho() {
		return Tachocounter.data();
	}

}
