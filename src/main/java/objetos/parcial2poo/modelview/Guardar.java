/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.parcial2poo.modelview;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import objetos.parcial2poo.model.Provider;

/**
 *
 * @author ESTUDIANTES
 */
public class Guardar {
    
    public void enviarMenu(String nom, String doc, Object menu, Object bebi) {
        int id = (int) (Math.random() * 10000);
        String men = menu.toString();
        String beb = bebi.toString();
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("Nombre", nom);
            datos.put("Documento", doc);
            datos.put("Menu", men);
            datos.put("Bebida", beb);
            Provider.guardarX("SeleccionMenu", String.valueOf(id), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
