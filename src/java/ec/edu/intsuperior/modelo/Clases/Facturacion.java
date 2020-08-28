/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Clases;

import ec.edu.intsuperior.modelo.Crud.CrudIvas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dellubuntu
 */
public class Facturacion {

    private final ArrayList<Articulos> productos = new ArrayList<>();
    private Cliente cliente = null;

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregar(double productosprecio, double cantidad, int ivas_idIvas, int idProductos, int productosidUsuario, String productoscodigo, String productosdetalle, String productosaccion, int proveedoreseliminar, Date proveedoresfecha) {
        Articulos a = new Articulos(productosprecio, cantidad, ivas_idIvas, idProductos, productosidUsuario, productoscodigo, productosdetalle, productosaccion, proveedoreseliminar, proveedoresfecha);
       if(a.getCantidad()!=1 || a.getCantidad()!=0)productos.add(a);
    }
public void agregarP(Articulos a){
    if(a.getCantidad()>1) productos.add(a);
    
}
    public double totaliva() {
        double t = 0;
        CrudIvas ci = new CrudIvas();
        for (Articulos aux : productos) {
            Ivas i = (Ivas) ci.obtenerDato(aux.getIvas_idIvas());
            t += ((i.getIvasporcentaje() != null) ? i.getIvasporcentaje() : 0) * (aux.getProductosprecio() / 100);
        }
        return Math.round(t * 100) / 100d;
    }

    public double descuentos() {

        return (totalgeneral() / 100) * totalporcentajeDescuentos();
    }

    public double totaldescuentos() {
        return totalgeneral() - descuentos();
    }

    public double totalporcentajeDescuentos() {
        int porcentajeDescuentos = 0;
        int cont = 0;
        if (numeroitems() > 3) {
            porcentajeDescuentos = 10;
        }
        for (Articulos aux : productos) {
            if (aux.getCantidad() > 1) {
                cont++;
            }
        }
        if (cont != 0) {
            porcentajeDescuentos = porcentajeDescuentos + 25;
        }
        if (totalgeneral() > 25) {
            porcentajeDescuentos = porcentajeDescuentos + 5;
        }
        return porcentajeDescuentos;

    }

    public double subtotalgeneral() {
        double t = 0;

        for (Articulos aux : productos) {
            t += (aux.getProductosprecio() * aux.getCantidad());
        }
        return Math.round(t * 100) / 100d;
    }

    public double totalgeneral() {
        double t = 0;
        for (Articulos aux : productos) {
            t += (aux.getProductosprecio() * aux.getCantidad());
        }
        t += totaliva();

        return Math.round(t * 100) / 100d;
    }

    public int numeroitems() {
        return productos.size();
    }

    public ArrayList listaArticulos() {
        return productos;
    }

    public void eliminar(int pos) {
        productos.remove(pos);
    }
}
