/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import com.mysql.jdbc.PreparedStatement;
import entidades.Registro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class AccesoDatos {

    public boolean crearRegistro(Registro elRegistroDeLogica) {
        try {

            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdnotas", "root", "");
            PreparedStatement sentencia = (PreparedStatement) cn.prepareStatement("insert into tbcalificaciones values (?,?,?,?,?,?,?,?)");

            sentencia.setString(1, "0");
            sentencia.setString(2, elRegistroDeLogica.getCedula());
            sentencia.setString(3, elRegistroDeLogica.getNombre());
            sentencia.setString(4, elRegistroDeLogica.getApellidos());
            sentencia.setString(5, String.valueOf(elRegistroDeLogica.getProgramacion2()));
            sentencia.setString(6, elRegistroDeLogica.getCalculo() + "");
            sentencia.setString(7, elRegistroDeLogica.getArte() + "");
            sentencia.setString(8, elRegistroDeLogica.getAdministracion() + "");
          

            sentencia.execute(); //Envia la sentencia a la base de datos

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error al conectar a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
//System.out.println(e.getMessage());
            return false;
        }
    }

    public Registro consultarPorCedula(String cedulaDeLogica) {
        Registro elRegistro = new Registro();
        try {
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdnotas", "root", "");
            PreparedStatement sentencia = (PreparedStatement) cn.prepareStatement("select * from tbcalificaciones where cedula = ?");

            sentencia.setString(1, cedulaDeLogica);

            ResultSet rs = sentencia.executeQuery(); //Tiene todos los registro de BD

            if (rs.next()) { //Si hay un registro
                //Creando la entidad
                elRegistro.setId(rs.getInt("id"));
                elRegistro.setCedula(rs.getString("cedula"));
                elRegistro.setNombre(rs.getString("nombre"));
                elRegistro.setApellidos(rs.getString("apellidos"));
                elRegistro.setProgramacion2(rs.getInt("programacion2"));
                elRegistro.setCalculo(rs.getInt("calculo"));
                elRegistro.setArte(rs.getInt("arte"));
                elRegistro.setAdministracion(rs.getInt("administracion"));

            } else {
                return null;
            }

            return elRegistro;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(new JFrame(), "Error al conectar a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            elRegistro = null;
            return elRegistro;
        }
    }

    public boolean actualizarRegistro(Registro elRegistroDeLogica) {
        try {
            com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdnotas", "root", "");
            PreparedStatement sentencia = (PreparedStatement) cn.prepareStatement("update tbcalificaciones set cedula = ?, nombre = ?, apellidos =?, programacion2 = ?, calculo = ?, arte = ?, administracion = ? where id = ?");

            sentencia.setString(1, String.valueOf(elRegistroDeLogica.getCedula()));
            sentencia.setString(2, String.valueOf(elRegistroDeLogica.getNombre()));
            sentencia.setString(3, String.valueOf(elRegistroDeLogica.getApellidos()));
            sentencia.setString(4, String.valueOf(elRegistroDeLogica.getProgramacion2()));
            sentencia.setString(5, String.valueOf(elRegistroDeLogica.getCalculo()));
            sentencia.setString(6, String.valueOf(elRegistroDeLogica.getArte()));
            sentencia.setString(7, String.valueOf(elRegistroDeLogica.getAdministracion()));
            sentencia.setString(8, String.valueOf(elRegistroDeLogica.getId()));

            sentencia.execute();

            return true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(new JFrame(), "Error al conectar a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }

    }

    public boolean eliminarRegistro(int idQueDeLogica) {
        try {
            com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdnotas", "root", "");
            PreparedStatement sentencia = (PreparedStatement) cn.prepareStatement("delete from tbcalificaciones where id = ?");

            sentencia.setInt(1, idQueDeLogica);

            sentencia.execute();

            return true;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(new JFrame(), "Error al conectar a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }

    }

    public List<Registro> traerTodosLosRegistros() {
        List<Registro> laListaDeRegistros = new ArrayList();
        try {
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdnotas", "root", "");
            PreparedStatement sentencia = (PreparedStatement) cn.prepareStatement("select * from tbcalificaciones");

            ResultSet rs = sentencia.executeQuery(); //Tiene todos los registro de BD

            while (rs.next()) { //Si hay un registro
//Creando la entidad
                Registro unRegistro = new Registro();

                unRegistro.setId(rs.getInt("id"));
                unRegistro.setCedula(rs.getString("cedula"));
                unRegistro.setNombre(rs.getString("nombre"));
                unRegistro.setApellidos(rs.getString("apellidos"));
                unRegistro.setProgramacion2(rs.getInt("programacion2"));
                unRegistro.setCalculo(rs.getInt("calculo"));
                unRegistro.setArte(rs.getInt("arte"));
                unRegistro.setAdministracion(rs.getInt("administracion"));
                

                laListaDeRegistros.add(unRegistro);

            }

            return laListaDeRegistros;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(new JFrame(), "Error al conectar a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            laListaDeRegistros = null;
            return laListaDeRegistros;
        }
    }

}
