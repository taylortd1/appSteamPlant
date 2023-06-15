package appSteamPlant;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Clock implements Runnable{

	SteamPlant steamPlant;
	Random rand = new Random();
	
	public Clock() {
		steamPlant = SteamPlant.getSteamPlant();
		
	}
	
	public void run() {
		int x = 0;
		while (x != 1) {
			try {
				TimeUnit.SECONDS.sleep(5);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			steamPlant.timeTick();
			 steamPlant.changeCurrentPressure(rand.nextInt(2) - 1);
			
			
		}
	}
}
