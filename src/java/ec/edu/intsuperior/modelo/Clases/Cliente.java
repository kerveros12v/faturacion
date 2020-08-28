/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Clases;

import ec.edu.intsuperior.vista.GeneradorEsquema;
import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class Cliente {

    private String apellido1 = "";
    private String apellido2 = "";
    private String nombre1 = "";
    private String nombre2 = "";
    private String cedula = "";
    private String correo = "";
    private String telefono = "";
    private String direccion = "";
    private String clientesaccion = "";
    private int idcliente = 0;
    private int clienteidUsuario = 0;
    private int clienteselimina = 0;
    private Date clientesfecha=null;

    /**
     * @return the clienteidUsuario
     */
    public int getClienteidUsuario() {
        return clienteidUsuario;
    }

    /**
     * @param clienteidUsuario the clienteidUsuario to set
     */
    public void setClienteidUsuario(int clienteidUsuario) {
        this.clienteidUsuario = clienteidUsuario;
    }

    /**
     * @return the clienteselimina
     */
    public int getClienteselimina() {
        return clienteselimina;
    }

    /**
     * @param clienteselimina the clienteselimina to set
     */
    public void setClienteselimina(int clienteselimina) {
        this.clienteselimina = clienteselimina;
    }

    /**
     * @return the clientesaccion
     */
    public String getClientesaccion() {
        return clientesaccion;
    }

    /**
     * @param clientesaccion the clientesaccion to set
     */
    public void setClientesaccion(String clientesaccion) {
        this.clientesaccion = clientesaccion;
    }

    /**
     * @return the clientesfecha
     */
    public Date getClientesfecha() {
        return clientesfecha;
    }

    /**
     * @param clientesfecha the clientesfecha to set
     */
    public void setClientesfecha(Date clientesfecha) {
        this.clientesfecha = clientesfecha;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(String apellido1, String apellido2, String nombre1, String nombre2, String cedula, String correo, String telefono, String direccion) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return nombre1;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return nombre2;
    }

    /**
     * @param nombre2 the nombre2 to set
     */
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {

        return "apellido1: " + apellido1 + " apellido2: " + apellido2 + " nombre1: " + nombre1 + " nombre2: " + nombre2
                + " cedula: " + cedula + " correo: " + correo + " telefono: " + telefono + " direccion: " + direccion
                + " idcliente: " + idcliente + " clienteidUsuario: " + clienteidUsuario + " clienteselimina: " + clienteselimina
                + " clientesaccion: " + clientesaccion
                + " clientesfecha: " + GeneradorEsquema.fecha(clientesfecha);
    }

}
