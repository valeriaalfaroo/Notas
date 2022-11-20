/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import accesoDatos.AccesoDatos;
import entidades.Registro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class Logica {

    public boolean crearRegistro(Registro registroDePresentacion) {
        if (registroDePresentacion.getNombre().isEmpty() || registroDePresentacion.getApellidos().isEmpty() || registroDePresentacion.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe incluir todos los datos", "Error en lógica", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

//Pasarlo a acceso a datos
            AccesoDatos laCapaDeAccesoDatos = new AccesoDatos();
            return laCapaDeAccesoDatos.crearRegistro(registroDePresentacion);
        }
    }

    public Registro consultarPorCedula(String cedulaDePresentacion) {
        Registro elRegistroDevolver = new Registro();
        if (cedulaDePresentacion.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "La cédula está vacía", "Error en lógica", JOptionPane.WARNING_MESSAGE);
            elRegistroDevolver = null;
        } else {
            AccesoDatos laCapaDeAccesoDatos = new AccesoDatos();

            elRegistroDevolver = laCapaDeAccesoDatos.consultarPorCedula(cedulaDePresentacion);

            if (elRegistroDevolver == null) {

                elRegistroDevolver = null;
            } else {
                elRegistroDevolver.setPromedio(calcularPromedio(elRegistroDevolver.getProgramacion2(), elRegistroDevolver.getCalculo(), elRegistroDevolver.getArte(), elRegistroDevolver.getAdministracion()));
                //return elRegistroDevolver;
                return elRegistroDevolver;
            }
        }
        return elRegistroDevolver;
    }

    public boolean actualizarRegistro(Registro registroDePresentacion) {
        if (registroDePresentacion.getNombre().isEmpty() || registroDePresentacion.getApellidos().isEmpty() || registroDePresentacion.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Debe incluir todos los datos", "Error en lógica", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

//Pasarlo a acceso a datos
            AccesoDatos laCapaDeAccesoDatos = new AccesoDatos();
            return laCapaDeAccesoDatos.actualizarRegistro(registroDePresentacion);
        }

    }

    private Double calcularPromedio(int notaProgra, int notaCalculo, int notaArte, int notaAdmi) {
        return (notaProgra + notaCalculo + notaArte + notaAdmi) / 4.0;
    }

    public boolean eliminarRegistro(int idDePresentacion) {
        if (idDePresentacion == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "El ID está vacío", "Error en lógica", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            AccesoDatos laCapaDeAccesoDatos = new AccesoDatos();
            return laCapaDeAccesoDatos.eliminarRegistro(idDePresentacion);
        }
    }

    public List<Registro> traerTodosLosRegistros() {
        
        AccesoDatos laCapaDeAccesoDatos = new AccesoDatos();
        List<Registro> listaCalculada = new ArrayList();
        listaCalculada= laCapaDeAccesoDatos.traerTodosLosRegistros();
        
        for(Registro cadaRegistro : listaCalculada){
        cadaRegistro.setPromedio(calcularPromedio(cadaRegistro.getProgramacion2(), cadaRegistro.getCalculo(), cadaRegistro.getArte(), cadaRegistro.getAdministracion()));
               
        }
        
        
        
        
        return listaCalculada;
        

    }
    
    
   
}
