
package modelo;

import java.util.Observable;
import javax.swing.ImageIcon;


public class Model extends Observable
{
    private WeatherStation wS;
    
    public Model()
    {
        wS = new WeatherStation();
    }
    
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
        update();
    }
    
    public void update()
    {
        wS.setOnline(false);
        wS.update();
        //System.out.println(this.getHumidity()+" <-- Humedad    "+this.getTemperature()+" °C");
        setChanged();
        notifyObservers();
    }
}
