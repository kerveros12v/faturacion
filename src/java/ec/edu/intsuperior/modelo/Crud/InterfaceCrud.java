/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Crud;

import java.util.ArrayList;

/**
 *
 * @author dellubuntu
 */
public interface InterfaceCrud {

    public boolean actualizar(Object dato);

    public boolean eliminar(Object dato);

    public boolean insertar(Object dato);

    public ArrayList<Object> mostrar();

    public Object obtenerDato(Object dato);

    public int existe(Object dato);

}
