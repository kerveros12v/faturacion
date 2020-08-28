/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import ec.edu.intsuperior.modelo.Clases.Usuarios;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author dellubuntu
 */
public class CrudUsuarios implements InterfaceCrud {

    Coneccion con = new Coneccion();
    Connection conexion;
    Statement stm = null;

    public CrudUsuarios() {

    }

    @Override
    public boolean actualizar(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Connection connect = null;
        stm = null;
        boolean registrar = false;
        Usuarios user = (Usuarios) dato;
        String sql = "UPDATE `Usuarios` SET `UsuarioNombre` =" + user.getUsuarioNombre()
                + " ,`usuarioNik` =" + user.getUsuarioNik()
                + " ,`Usuarioclave` =" + user.getUsuarioclave()
                + " WHERE `idUsuario` = " + user.getIdUsuario()
                + ";";
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
    public boolean eliminar(Object dato) {
        Usuarios usuarios = (Usuarios) dato;
        con.connectDatabase();
        conexion = con.conn;
        boolean registrar = false;
        String sql = "DELETE FROM `Usuarios WHERE `idUsuario`=" + usuarios.getIdUsuario() + ";";
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
 registrar = true;
            stm.close();
            conexion.close();
        } catch (SQLException e) {
        }
        return registrar;
    }

    @Override
    public boolean insertar(Object dato) {
        Usuarios usuarios = (Usuarios) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;
        String sql = "INSERT INTO `Usuarios`(`idUsuario`,`UsuarioNombre`,`usuarioNik`,`Usuarioclave`)VALUES (NULL," + usuarios.getUsuarioNombre() + "," + usuarios.getUsuarioNik() + "," + usuarios.getUsuarioclave() + ");";
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            conexion.close();
        } catch (SQLException e) {
        }
return registrar;
    }

    @Override
    public ArrayList<Object> mostrar() {
        con.connectDatabase();
        conexion = con.conn;
       stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM CLIENTE ORDER BY ID";

        ArrayList<Object> listaUsuarios = new ArrayList<>();

        try {

            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuarios c = new Usuarios();
                c.setIdUsuario(rs.getInt(1));
                c.setUsuarioNik(rs.getString(2));
                c.setUsuarioNombre(rs.getString(3));
                c.setUsuarioclave(rs.getString(4));
                listaUsuarios.add(c);
            }
            stm.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            return null;
        }

        return listaUsuarios;
    }

    @Override
    public Object obtenerDato(Object dato) {

        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        Usuarios recibido = (Usuarios) dato;

        recibido.setUsuarioclave(recibido.getUsuarioclave());
        String sql = "SELECT * FROM Usuarios WHERE usuarioNik='" + recibido.getUsuarioNik() + "' AND Usuarioclave ='" + recibido.getUsuarioclave() + "';";

        Usuarios c = new Usuarios();

        try {

            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c.setIdUsuario(rs.getInt(1));
                c.setUsuarioNik(rs.getString(3));
                c.setUsuarioNombre(rs.getString(2));
                c.setUsuarioclave(rs.getString(4));

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
    public int existe(Object dato) {
        con.connectDatabase();
        conexion = con.conn;
        Statement stm1 = null;
        ResultSet rs = null;
        Usuarios recibido = (Usuarios) dato;

        recibido.setUsuarioclave(recibido.getUsuarioclave());
        String sql = "SELECT * FROM Usuarios WHERE usuarioNik='" + recibido.getUsuarioNik() + "' AND Usuarioclave ='" + recibido.getUsuarioclave() + "';";

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
