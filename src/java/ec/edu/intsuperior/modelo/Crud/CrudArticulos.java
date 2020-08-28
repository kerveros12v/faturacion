/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import ec.edu.intsuperior.modelo.Clases.Articulos;
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
public class CrudArticulos implements InterfaceCrud {

    Coneccion con = new Coneccion();
    Connection conexion;
    Statement stm = null;

    /**
     * Ingrese el id del articulo para poder eliminar el producto señalado
     *
     * @param dato
     * @return
     */
    @Override
    public boolean eliminar(Object dato) {
        String articulo = (String) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;//GeneradorEsquema.fecha(cliente.getClientesfecha())
        String sql = "DELETE FROM `Productos` WHERE idProductos=" + articulo + ";";
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

    @Override
    public boolean insertar(Object dato) {
        Articulos articulos = (Articulos) dato;
        boolean registrar = false;
        con.connectDatabase();
        conexion = con.conn;//GeneradorEsquema.fecha(cliente.getClientesfecha())
        String sql = "INSERT INTO `Productos` (`idProductos`,`productoscodigo`,`productosdetalle`,`ivas_idIvas`,`productosprecio`,`productosidUsuario`,`productosaccion`,`productosfecha`,`productoseliminar`)\n"
                + "VALUES ('" + null + " ','" + articulos.getProductoscodigo() + " ','" + articulos.getProductosdetalle() + " ','" + articulos.getIvas_idIvas() + " ','" + articulos.getProductosprecio() + " ','" + articulos.getProductosidUsuario() + " ','" + articulos.getProductosaccion() + " ','" + GeneradorEsquema.fecha(articulos.getProductosfecha()) + " ','" + articulos.getProductoseliminar() + " ');\n"
                + " ";
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
     * Retorna una lista de objetos tipo Articulos
     *
     * @return
     */
    @Override
    public ArrayList<Object> mostrar() {
        con.connectDatabase();
        conexion = con.conn;
        stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Productos;";

        ArrayList<Object> listaclientes = new ArrayList<>();

        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Articulos c = new Articulos();
                c.setIdProductos(rs.getInt(1));
                c.setProductoscodigo(rs.getString(2));
                c.setProductosdetalle(rs.getString(3));
                c.setIvas_idIvas(rs.getInt(4));
                c.setProductosprecio(rs.getDouble(5));
                c.setProductosidUsuario(rs.getInt(6));
                c.setProductosaccion(rs.getString(7));
                c.setProductosfecha(rs.getDate(8));
                c.setProductoseliminar(rs.getInt(9));
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
     * permite obtener un articulo usando el codigo del producto
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
        String recibido = (String) dato;
        String sql = "SELECT * FROM Productos WHERE productoscodigo='" + recibido + "';";
        Articulos c = new Articulos();
        try {
            stm1 = conexion.createStatement();
            rs = stm1.executeQuery(sql);
            while (rs.next()) {
                c.setIdProductos(rs.getInt(1));
                c.setProductoscodigo(rs.getString(2));
                c.setProductosdetalle(rs.getString(3));
                c.setIvas_idIvas(rs.getInt(4));
                c.setProductosprecio(rs.getDouble(5));
                c.setProductosidUsuario(rs.getInt(6));
                c.setProductosaccion(rs.getString(7));
                c.setProductosfecha(rs.getDate(8));
                c.setProductoseliminar(rs.getInt(9));
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
        Articulos u = (Articulos) dato;
        String sql = "UPDATE `Productos` SET "
                + "`idProductos` = "+u.getIdProductos()+","
                + "`productoscodigo` = '"+u.getProductoscodigo()+"',"
                + "`productosdetalle` ='"+u.getProductosdetalle()+"',"
                + "`ivas_idIvas` = "+u.getIvas_idIvas()+","
                + "`productosprecio` = "+u.getProductosprecio()+","
                + "`productosidUsuario` = "+u.getProductosidUsuario()+","
                + "`productosaccion` = "+u.getProductosaccion()+","
                + "`productosfecha` = '"+GeneradorEsquema.fecha(u.getProductosfecha())+"',"
                + "`productoseliminar` ="+u.getProductoseliminar()
                + " WHERE `idProductos` = "+u.getIdProductos()+";";
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
     * Comprueba si existe un registro con el codigo ingresado
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
        Articulos recibido = (Articulos) dato;
        String sql = "SELECT * FROM Productos WHERE productoscodigo='" + recibido.getProductoscodigo() + "';";

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
