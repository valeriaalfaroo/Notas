/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Johan
 */
public class Registro {

    private int id;
    private String cedula;
    private String nombre;
    private String apellidos;
    private int programacion2;
    private int calculo;
    private int arte;
    private int administracion;
    private double promedio;

    public Registro(int id, String cedula, String nombre, String apellidos, int programacion2, int calculo, int arte, int administracion) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.programacion2 = programacion2;
        this.calculo = calculo;
        this.arte = arte;
        this.administracion = administracion;
    }

    public Registro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getProgramacion2() {
        return programacion2;
    }

    public void setProgramacion2(int programacion2) {
        this.programacion2 = programacion2;
    }

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    public int getArte() {
        return arte;
    }

    public void setArte(int arte) {
        this.arte = arte;
    }

    public int getAdministracion() {
        return administracion;
    }

    public void setAdministracion(int administracion) {
        this.administracion = administracion;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

            
}
