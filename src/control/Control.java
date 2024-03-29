/*
 * Informacion referente al ActionListener = http://chuwiki.chuidiang.org/index.php?title=ActionListener
 * 
 * Informacion referente a al Observer y Observable: http://proton.ucting.udg.mx/tutorial/java/Apendice/ob_uso.html
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Model;
import vista.View;
public class Control implements ActionListener
{
    Model model;
    View vista;
    
    public Control ()
    {
        model = new Model();
        vista = new View(model,this);
        model.addObserver(vista);
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if(comando.equals("actualizar"))
        {
            model.update();
        }
        if(comando.equals("cambiar ciudad"))
        {
            model.setCity(vista.getCiudadItem());
            model.update();
        }
        if(comando.equals("inicio"))
        {
            //model.setCity("pereira");
            model.setCity("Barranquilla");
            model.update();
        }
    }
    
    public static void main( String args[] ) {        
        Control m = new Control();
        }
}
