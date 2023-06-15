package appSteamPlant;
public class SteamPlant
{
    private double MAX_PRESSURE;
    private double MIN_PRESSURE;
    private double INITIAL_PRESSURE;
    private double INITIAL_HEAT_AVAILABLE;
    private double currentPressure;
    private int heatAvailable;
    private static SteamPlant uniqueInstance;
    
    private SteamPlant(){
     SteamPlant plant1 = new SteamPlant();
     currentPressure = INITIAL_PRESSURE;
     heatAvailable = (int) INITIAL_HEAT_AVAILABLE;
     
    }
    
    public static SteamPlant getSteamPlant() {
     
    	if (uniqueInstance == null) {
    		synchronized(SteamPlant.class) {
    			if (uniqueInstance == null) {
    				uniqueInstance = new SteamPlant();
    			}
    		}
    	}
    	
    	return uniqueInstance;
        
    }
    
    public int consumeHeat(int h) {
        
        int x = 0;
        
        if (h > heatAvailable) {
            
            x = heatAvailable;
            heatAvailable = 0;
            return x;
        }
        else if(h <= heatAvailable) {
            
            x = heatAvailable - h;
            
        }
        System.out.println("ConsumeHeat, the heat available = " + heatAvailable + 
        		"the current pressure = " + currentPressure + 
        		"the parameter passed was " + h + ", the retun value is " + x);
        return x;
    }
    public void setCurrentPressure(double p) {
        
        if(p > MAX_PRESSURE) {
            currentPressure = MAX_PRESSURE;
        }
        if(p < MIN_PRESSURE) {
            currentPressure = MIN_PRESSURE;
        }
    }
    
    public double changeCurrentPressure(double p) {
        
        while (currentPressure <= MAX_PRESSURE && currentPressure >= MIN_PRESSURE) {
            
            currentPressure = currentPressure + p;
        }
        
        return currentPressure;
    }
    
    public void timeTick() {
     
        if((currentPressure - 2) * 500 > (currentPressure - 2) * 0 ) {
        
            heatAvailable = (int) ((currentPressure - 2) * 500);
    }
        else heatAvailable = (int) ((currentPressure - 2) * 0);
    
        System.out.println("timeTick, the heat available = " + heatAvailable + 
        		"the current pressure = " + currentPressure);
    
    }
}
