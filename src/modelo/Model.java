
package modelo;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.ImageIcon;
import java.util.Collections;


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
    }
    
    public String getCityName()
    {
        return wS.getCityName();
    }
    
    public String[] getCiudades()
    {
        String[] ciudades = wS.getCityNames();
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i < ciudades.length; i++) {
            lista.add(ciudades[i]);
        }
        Collections.sort(lista);
        
        
        String[] ciudadesOrden = new String[ciudades.length];
        String[] toArray = lista.toArray(ciudadesOrden);
            
     
        return ciudadesOrden;
        
    }
    
    public void setCity(String city)
    {
        wS.setCityName(city);
        wS.update();
    }
    public void update()
    {
        wS.setOnline(true);
        wS.update();
        //System.out.println(this.getHumidity()+" <-- Humedad    "+this.getTemperature()+" °C");
        setChanged();
        notifyObservers();
    }
}
