/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import ec.edu.intsuperior.modelo.Clases.Ivas;
import ec.edu.intsuperior.vista.GeneradorEsquema;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dellubuntu
 */
public class CrudIvas implements InterfaceCrud {

    Coneccion con = new Coneccion();
    Connection conexion;
    Statement stm = null;
/**
 * Actualiza el registro existente en la base de datos
 * Requiere un objeto de tipo Ivas
 * @param dato
 * @return 
 */
    @Override
    public boolean actualizar(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Connection connect = null;
        stm = null;
        boolean registrar = false;
        Ivas u = (Ivas) dato;
        String sql = "UPDATE `Ivas`\n"
                + "SET\n"
                + "`idIvas` = "+u.getIdIvas()+","
                + "`ivascodigo` = "+u.getIvascodigo()+","
                + "`ivasDetalle` = "+u.getIvasDetalle()+","
                + "`ivasporcentaje` = "+u.getIvasporcentaje()+","
                + "`ivaidUsuario` = "+u.getIvaidUsuario()+","
                + "`ivaaccion` = "+u.getIvaaccion()+","
                + "`ivafecha` = "+GeneradorEsquema.fecha(u.getIvafecha())+","
                + "`ivaeliminar` = "+u.getIvaeliminar()+""
                + "WHERE `idIvas` = "+u.getIdIvas()+";";
        try {
            connect = conexion;
            stm = connect.createStatement();
            stm.execute(sql);
            registrar = true;
        } catch (SQLException e) {
        }
        return registrar;
    }
/**
 * Requiere el id de la base de datos para poder eliminar el elemento
 * @param dato
 * @return 
 */
    @Override
    public boolean eliminar(Object dato) {
        //DELETE FROM `Ivas` WHERE <{where_expression}>;

        String ivaId = (String) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;//GeneradorEsquema.fecha(cliente.getClientesfecha())
        String sql = "DELETE FROM `Ivas` WHERE idIvas=" + ivaId + ";";
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
     * Guarda los datos en la base de datos Requiere un objeto tipo Iva
     *
     * @param dato
     * @return
     */
    @Override
    public boolean insertar(Object dato) {
        Ivas d = (Ivas) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;//GeneradorEsquema.fecha(cliente.getClientesfecha())
        String sql = "INSERT INTO `Ivas` (`ivascodigo`,`ivasDetalle`,`ivasporcentaje`,`ivaidUsuario`,`ivaaccion`,`ivafecha`,`ivaeliminar`) VALUES ('" + d.getIvascodigo() + "','" + d.getIvasDetalle() + "'," + d.getIvasporcentaje() + "," + d.getIvaidUsuario() + ",'" + d.getIvaaccion() + "','" + GeneradorEsquema.fecha(d.getIvafecha()) + "'," + d.getIvaeliminar() + ");";

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
 * Muestra la lista completa de los registros almacenados en la base de datos
 * @return 
 */
    @Override
    public ArrayList<Object> mostrar() {
        con.connectDatabase();
        conexion = con.conn;
        stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Ivas;";

        ArrayList<Object> lista = new ArrayList<>();

        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Ivas c = new Ivas();
                c.setIdIvas(rs.getInt(1));
                c.setIvascodigo(rs.getString(2));
                c.setIvasDetalle(rs.getString(3));
                c.setIvasporcentaje(rs.getDouble(4));
                c.setIvaidUsuario(rs.getInt(5));
                c.setIvaaccion(rs.getString(6));
                c.setIvafecha(rs.getDate(7));
                c.setIvaeliminar(rs.getInt(8));
                lista.add(c);
            }
            stm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return null;
        }

        return lista;
    }

    /**
     * Funcion que retorna un objeto tipo iva recive un entero aciendo
     * referencia al id de la base de datos
     *
     * @param dato
     * @return
     */
    @Override
    public Object obtenerDato(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        int recibido = (int) dato;
        String sql = "SELECT * FROM Ivas WHERE idIvas=" + recibido + ";";
        Ivas c = new Ivas();
        try {
            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c.setIdIvas(rs.getInt(1));
                c.setIvascodigo(rs.getString(2));
                c.setIvasDetalle(rs.getString(3));
                c.setIvasporcentaje(rs.getDouble(4));
                c.setIvaidUsuario(rs.getInt(5));
                c.setIvaaccion(rs.getString(6));
                c.setIvafecha(rs.getDate(7));
                c.setIvaeliminar(rs.getInt(8));
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
     * Fucion para la rebicion de existencia recibe un objeto de tipo Iva para
     * su validacion correcta
     *
     * @param dato
     * @return
     */
    @Override
    public int existe(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        Ivas recibido = (Ivas) dato;
        String sql = "SELECT * FROM Clientes WHERE idIvas='" + recibido.getIdIvas() + "';";

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
