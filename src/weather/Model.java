
package weather;

import javax.swing.ImageIcon;


public class Model extends java.util.Observable
{
    private WeatherStation wS = new WeatherStation();
    
    public int getHumidity(){
        return wS.getHumidity();
    }
    
    public int getTemperature(){
        return wS.getTemperature();
    }
    
    public String getSunrise(){
        return wS.getSunrise();
    }
    
    public String getSunset(){
        return wS.getSunset();
    }
    
    public ImageIcon getIcon(){
        return wS.getIcon();
    }
    
    public void setOnline(boolean onLine){
        wS.setOnline(onLine);
    }
    
    public void update(){
        wS.update();
        setChanged();
        notifyObservers();
    }
}
