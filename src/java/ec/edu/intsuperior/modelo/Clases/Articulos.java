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
public class Articulos {



    private double productosprecio, cantidad,descuentos;
    private int ivas_idIvas, idProductos, productosidUsuario, productoseliminar;
    private String productoscodigo, productosdetalle, productosaccion;
    private Date productosfecha;

    public Articulos() {
    }

    public Articulos(double productosprecio, double cantidad, int ivas_idIvas, int idProductos, int productosidUsuario, String productoscodigo, String productosdetalle, String productosaccion, int productoseliminar, Date productosfecha) {
        this.productosprecio = productosprecio;
        this.cantidad = cantidad;
        this.ivas_idIvas = ivas_idIvas;
        this.idProductos = idProductos;
        this.productosidUsuario = productosidUsuario;
        this.productoscodigo = productoscodigo;
        this.productosdetalle = productosdetalle;
        this.productosaccion = productosaccion;
        this.productoseliminar = productoseliminar;
        this.productosfecha = productosfecha;
    }
    /**
     * @return the descuentos
     */
    public double getDescuentos() {
        return descuentos;
    }

    /**
     * @param descuentos the descuentos to set
     */
    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }
    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the productosprecio
     */
    public double getProductosprecio() {
        return productosprecio;
    }

    /**
     * @param productosprecio the productosprecio to set
     */
    public void setProductosprecio(double productosprecio) {
        this.productosprecio = productosprecio;
    }

    /**
     * @return the ivas_idIvas
     */
    public int getIvas_idIvas() {
        return ivas_idIvas;
    }

    /**
     * @param ivas_idIvas the ivas_idIvas to set
     */
    public void setIvas_idIvas(int ivas_idIvas) {
        this.ivas_idIvas = ivas_idIvas;
    }

    /**
     * @return the idProductos
     */
    public int getIdProductos() {
        return idProductos;
    }

    /**
     * @param idProductos the idProductos to set
     */
    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    /**
     * @return the productosidUsuario
     */
    public int getProductosidUsuario() {
        return productosidUsuario;
    }

    /**
     * @param productosidUsuario the productosidUsuario to set
     */
    public void setProductosidUsuario(int productosidUsuario) {
        this.productosidUsuario = productosidUsuario;
    }

    /**
     * @return the productoscodigo
     */
    public String getProductoscodigo() {
        return productoscodigo;
    }

    /**
     * @param productoscodigo the productoscodigo to set
     */
    public void setProductoscodigo(String productoscodigo) {
        this.productoscodigo = productoscodigo;
    }

    /**
     * @return the productosdetalle
     */
    public String getProductosdetalle() {
        return productosdetalle;
    }

    /**
     * @param productosdetalle the productosdetalle to set
     */
    public void setProductosdetalle(String productosdetalle) {
        this.productosdetalle = productosdetalle;
    }

    /**
     * @return the productosaccion
     */
    public String getProductosaccion() {
        return productosaccion;
    }

    /**
     * @param productosaccion the productosaccion to set
     */
    public void setProductosaccion(String productosaccion) {
        this.productosaccion = productosaccion;
    }

    /**
     * @return the productoseliminar
     */
    public int getProductoseliminar() {
        return productoseliminar;
    }

    /**
     * @param productoseliminar the productoseliminar to set
     */
    public void setProductoseliminar(int productoseliminar) {
        this.productoseliminar = productoseliminar;
    }

    /**
     * @return the productosfecha
     */
    public Date getProductosfecha() {
        return productosfecha;
    }

    /**
     * @param productosfecha the productosfecha to set
     */
    public void setProductosfecha(Date productosfecha) {
        this.productosfecha = productosfecha;
    }

}
