/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Clases;

import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class Ivas {

    private int idIvas;
    private int ivaidUsuario;
    private int ivaeliminar;
    private String ivascodigo;
    private String ivasDetalle;
    private String ivaaccion;
    private Double ivasporcentaje;
    private Date ivafecha;

    /**
     * @return the idIvas
     */
    public int getIdIvas() {
        return idIvas;
    }

    /**
     * @param idIvas the idIvas to set
     */
    public void setIdIvas(int idIvas) {
        this.idIvas = idIvas;
    }

    /**
     * @return the ivaidUsuario
     */
    public int getIvaidUsuario() {
        return ivaidUsuario;
    }

    /**
     * @param ivaidUsuario the ivaidUsuario to set
     */
    public void setIvaidUsuario(int ivaidUsuario) {
        this.ivaidUsuario = ivaidUsuario;
    }

    /**
     * @return the ivaeliminar
     */
    public int getIvaeliminar() {
        return ivaeliminar;
    }

    /**
     * @param ivaeliminar the ivaeliminar to set
     */
    public void setIvaeliminar(int ivaeliminar) {
        this.ivaeliminar = ivaeliminar;
    }

    /**
     * @return the ivascodigo
     */
    public String getIvascodigo() {
        return ivascodigo;
    }

    /**
     * @param ivascodigo the ivascodigo to set
     */
    public void setIvascodigo(String ivascodigo) {
        this.ivascodigo = ivascodigo;
    }

    /**
     * @return the ivasDetalle
     */
    public String getIvasDetalle() {
        return ivasDetalle;
    }

    /**
     * @param ivasDetalle the ivasDetalle to set
     */
    public void setIvasDetalle(String ivasDetalle) {
        this.ivasDetalle = ivasDetalle;
    }

    /**
     * @return the ivaaccion
     */
    public String getIvaaccion() {
        return ivaaccion;
    }

    /**
     * @param ivaaccion the ivaaccion to set
     */
    public void setIvaaccion(String ivaaccion) {
        this.ivaaccion = ivaaccion;
    }

    /**
     * @return the ivasporcentaje
     */
    public Double getIvasporcentaje() {
        return ivasporcentaje;
    }

    /**
     * @param ivasporcentaje the ivasporcentaje to set
     */
    public void setIvasporcentaje(Double ivasporcentaje) {
        this.ivasporcentaje = ivasporcentaje;
    }

    /**
     * @return the ivafecha
     */
    public Date getIvafecha() {
        return ivafecha;
    }

    /**
     * @param ivafecha the ivafecha to set
     */
    public void setIvafecha(Date ivafecha) {
        this.ivafecha = ivafecha;
    }

}
