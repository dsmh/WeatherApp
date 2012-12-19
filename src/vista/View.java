/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Model;
import control.Control;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author dsm
 */
public class View extends javax.swing.JFrame implements Observer{

    Model modelo = null;
    Control control;
    /**
     * Creates new form View
     */
    public View(Model modelo,Control control) {
        initComponents();
        //Carga las ciudades DISPONIBLES EN EL MODELO a la lista de seleccion
        String[] ciudades = modelo.getCiudades();
        int tamanio = ciudades.length;
        for(int i = 0; tamanio>0;i++)
        {
            this.selectCiudades.addItem(ciudades[i]);
            tamanio--;
        }
        //Fin carga de ciudades
        this.control = control;
        this.modelo = modelo;
        this.selectCiudades.addActionListener(this.control);
        this.selectCiudades.setActionCommand("cambiar ciudad");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        humedadLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        temperaturaLabel = new javax.swing.JLabel();
        ciudadLabel = new javax.swing.JLabel();
        selectCiudades = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amanecerLabel = new javax.swing.JLabel();
        anochecerLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        velocidadLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        visibilidadLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        presionLabel = new javax.swing.JLabel();
        forecastLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Humedad");

        humedadLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        humedadLabel.setForeground(new java.awt.Color(241, 39, 1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Temperatura");

        temperaturaLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        temperaturaLabel.setForeground(new java.awt.Color(241, 39, 1));

        ciudadLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ciudadLabel.setForeground(new java.awt.Color(3, 58, 239));
        ciudadLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        selectCiudades.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(11, 0, 91));
        jLabel3.setText("Amanecer: ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 0, 91));
        jLabel4.setText("Anochecer: ");

        amanecerLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        amanecerLabel.setForeground(new java.awt.Color(11, 0, 91));

        anochecerLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        anochecerLabel.setForeground(new java.awt.Color(11, 0, 91));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 0, 91));
        jLabel5.setText("Velocidad del Viento:");
        jLabel5.setToolTipText("");

        velocidadLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        velocidadLabel.setForeground(new java.awt.Color(11, 0, 91));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 0, 91));
        jLabel6.setText("Visibilidad: ");

        visibilidadLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        visibilidadLabel.setForeground(new java.awt.Color(11, 0, 91));
        visibilidadLabel.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(11, 0, 91));
        jLabel7.setText("Presión:");

        presionLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        presionLabel.setForeground(new java.awt.Color(11, 0, 91));

        forecastLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forecastLabel.setForeground(new java.awt.Color(18, 1, 139));
        forecastLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecastLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        forecastLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(243, 4, 4)));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("<--- Seleccione una ciudad.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anochecerLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amanecerLabel))
                            .addComponent(ciudadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(humedadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(temperaturaLabel)))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(forecastLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selectCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(velocidadLabel)
                    .addComponent(visibilidadLabel)
                    .addComponent(presionLabel))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(ciudadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(humedadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(temperaturaLabel)
                                    .addComponent(presionLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(velocidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(visibilidadLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(3, 3, 3)
                        .addComponent(forecastLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amanecerLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(anochecerLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amanecerLabel;
    private javax.swing.JLabel anochecerLabel;
    private javax.swing.JLabel ciudadLabel;
    private javax.swing.JLabel forecastLabel;
    private javax.swing.JLabel humedadLabel;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel presionLabel;
    private javax.swing.JComboBox selectCiudades;
    private javax.swing.JLabel temperaturaLabel;
    private javax.swing.JLabel velocidadLabel;
    private javax.swing.JLabel visibilidadLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object obj) {
        if(o == modelo)
        {
            icono.setIcon(modelo.getIcon());
            temperaturaLabel.setText(modelo.getTemperature()+" °C");
            humedadLabel.setText(modelo.getHumidity()+" %");
            ciudadLabel.setText(modelo.getCityName());
            amanecerLabel.setText(modelo.getSunrise());
            anochecerLabel.setText(modelo.getSunset());
            presionLabel.setText(modelo.getPressure()+" mb");
            visibilidadLabel.setText(modelo.getVisibilidad()+" Km");
            velocidadLabel.setText(modelo.getVelocidad()+" Km/h");
            forecastLabel.setText("<html>"+modelo.getForecast());
            
            
            String forecast = modelo.getForecast();
            //System.out.println("Forecast: "+forecast);
            //System.out.println(modelo.getHumidity()+" <-- Humedad    "+modelo.getTemperature()+" °C");
        }
    }
    
    public String getCiudadItem()
    {
        return selectCiudades.getSelectedItem().toString();
    }
    
    
    
    
}
