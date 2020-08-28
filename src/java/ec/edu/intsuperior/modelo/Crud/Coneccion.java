/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author dellubuntu
 */
public class Coneccion {

    Connection conn = null;
    String basedatos = "Tarea3_Facturacion";
    String host = "127.0.0.1:3306";
    String usuario = "remoto";
    String clave = "Katekio12v.";

    public Coneccion() {

    }

    public boolean connectDatabase() {
        try {
            // We register the MySQL (MariaDB) driver
            // Registramos el driver de MySQL (MariaDB)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
                return false;
            }

            // Database connect
            // Conectamos con la base de datos
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + basedatos + "?useTimezone=true&serverTimezone=UTC",
                    usuario, clave);
            boolean valid = conn.isValid(50000);
            return valid;
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error : " + sqle);
            return false;
        }
    }

   
}
