package appSteamPlant;

import java.util.concurrent.TimeUnit;

public class Building implements Runnable{

	SteamPlant steamPlant;
	public int size;
	public int thermostatSetting;
	public int outsideTemperature;
	
	public Building(int size, int thermostatSetting, int outsideTemperature) {
		
		this.size = size;
		this.thermostatSetting = thermostatSetting;
		steamPlant = SteamPlant.getSteamPlant();
	}
	
	public void run() {
		
		int x = 0;
		while (x != 1) {
			
			try {
				TimeUnit.SECONDS.sleep(3);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if ((thermostatSetting-outsideTemperature)*size/2400 > (thermostatSetting-outsideTemperature)*size/0) {
				
				steamPlant.consumeHeat((thermostatSetting-outsideTemperature)*size/2400);
			}
			else {
				steamPlant.consumeHeat((thermostatSetting-outsideTemperature)*size/0);
			}
			
		}
	}
	
	
}
