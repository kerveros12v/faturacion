/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import ec.edu.intsuperior.modelo.Clases.Cliente;
import ec.edu.intsuperior.vista.GeneradorEsquema;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dellubuntu
 */
public class CrudClientes implements InterfaceCrud {

    Coneccion con = new Coneccion();
    Connection conexion;
    Statement stm = null;

    /**
     * Recibe un dato tipo Int o String Elimina permanentemente los datos de la
     * base de datos el dato a recibir debe ser el id registro en la base de
     * datos
     *
     * @param dato
     * @return verdadero o falso
     */
    @Override
    public boolean eliminar(Object dato) {
        String cliente = (String) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;//GeneradorEsquema.fecha(cliente.getClientesfecha())
        String sql = "DELETE FROM `Clientes` WHERE idClientes=" + cliente + ";";
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            registrar = false;
        }
        return registrar;
    }

    /**
     * Almacena en ala base de datos Se solicita un objeto de tipo cliente
     *
     * @param dato
     * @return
     */
    @Override
    public boolean insertar(Object dato) {
        Cliente cliente = (Cliente) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;
        String sql = "INSERT INTO `Clientes`(`clientescedula`,`clientesapellido1`,`clientesapellido2`,`clientesnombre1`,`clientesnombre2`,`clientestelefono`,`clientescorreo`,`clientesdireccion`,`clienteidUsuario`,`clientesaccion`,`clientesfecha`,`clienteseliminar`)\n"
                + "VALUES ('" + cliente.getCedula() + "','" + cliente.getApellido1() + "','" + cliente.getApellido2() + "','" + cliente.getNombre1() + "','" + cliente.getNombre2() + "','" + cliente.getTelefono() + "','" + cliente.getCorreo() + "','" + cliente.getDireccion() + "'," + cliente.getClienteidUsuario() + ",'" + cliente.getClientesaccion() + "','" + GeneradorEsquema.fecha(cliente.getClientesfecha()) + "'," + cliente.getClienteselimina() + ");";
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            registrar = false;
        }
        return registrar;
    }

    /**
     * Permite la obtencion de toda la lista de clientes registrada en la base
     * de datos
     *
     * @return
     */
    @Override
    public ArrayList<Object> mostrar() {
        con.connectDatabase();
        conexion = con.conn;
        stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Clientes;";

        ArrayList<Object> listaclientes = new ArrayList<>();

        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setApellido1(rs.getString(3));
                c.setApellido2(rs.getString(4));
                c.setNombre1(rs.getString(5));
                c.setNombre2(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setClienteidUsuario(rs.getInt(10));
                c.setClientesaccion(rs.getString(11));
                c.setClientesfecha(rs.getDate(12));
                c.setClienteselimina(rs.getInt(13));
                listaclientes.add(c);
            }
            stm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return null;
        }

        return listaclientes;
    }

    /**
     * Permite obtener el dato ingresando un numero entero.
     *
     * @param dato
     * @return Objeto tipo Cliente
     */
    @Override
    public Object obtenerDato(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        int recibido = (int) dato;
        String sql = "SELECT * FROM Clientes WHERE idClientes=" + recibido + ";";
        Cliente c = new Cliente();
        try {
            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setApellido1(rs.getString(3));
                c.setApellido2(rs.getString(4));
                c.setNombre1(rs.getString(5));
                c.setNombre2(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setClienteidUsuario(rs.getInt(10));
                c.setClientesaccion(rs.getString(11));
                c.setClientesfecha(rs.getDate(12));
                c.setClienteselimina(rs.getInt(13));
            }
            stm1.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return null;
        }

        return c;
    }

    /**
     * Permite la obtencion de los datos del cliente atraves del numero de
     * identificacion
     *
     * @param dato
     * @return
     */
    public Cliente obtenerDato(String dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        String recibido = dato;
        String sql = "SELECT * FROM Clientes WHERE clientescedula='" + recibido + "';";
        Cliente c = new Cliente();
        try {
            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c.setIdcliente(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setApellido1(rs.getString(3));
                c.setApellido2(rs.getString(4));
                c.setNombre1(rs.getString(5));
                c.setNombre2(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setDireccion(rs.getString(9));
                c.setClienteidUsuario(rs.getInt(10));
                c.setClientesaccion(rs.getString(11));
                c.setClientesfecha(rs.getDate(12));
                c.setClienteselimina(rs.getInt(13));
            }
            stm1.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return null;
        }

        return c;
    }

    @Override
    public boolean actualizar(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Connection connect = null;
        stm = null;
        boolean registrar = false;
        Cliente u = (Cliente) dato;
        String sql = "UPDATE `Clientes`\n"
                + "SET\n"
                + "`idClientes` = " + u.getIdcliente() + ","
                + "`clientescedula` = " + u.getCedula() + ","
                + "`clientesapellido1` = " + u.getApellido1() + ","
                + "`clientesapellido2` = " + u.getApellido2() + ","
                + "`clientesnombre1` = " + u.getNombre1() + ","
                + "`clientesnombre2` = " + u.getNombre2() + ","
                + "`clientestelefono` = " + u.getTelefono() + ","
                + "`clientescorreo` = " + u.getCorreo() + ","
                + "`clientesdireccion` = " + u.getDireccion() + ","
                + "`clienteidUsuario` = " + u.getClienteidUsuario() + ","
                + "`clientesaccion` = " + u.getClientesaccion() + ","
                + "`clientesfecha` = " + GeneradorEsquema.fecha(u.getClientesfecha()) + ","
                + "`clienteseliminar` = " + u.getClienteselimina()
                + "WHERE `idClientes` = " + u.getIdcliente() + ";";
        try {
            connect = conexion;
            stm = connect.createStatement();
            stm.execute(sql);
            registrar = true;
        } catch (SQLException e) {
        }
        return registrar;
    }

    @Override
    public int existe(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        Cliente recibido = (Cliente) dato;
        String sql = "SELECT * FROM Clientes WHERE clientescedula='" + recibido.getCedula() + "';";

        int c = 0;

        try {

            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c++;
            }
            stm1.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return c;
        }

        return c;
    }

}
