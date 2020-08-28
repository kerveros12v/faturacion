/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo.Clases;

/**
 *
 * @author dellubuntu
 */
public class Usuarios {
    	private int idUsuario;
	private String usuarioNombre;
	private String usuarioNik;
	private String Usuarioclave;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the UsuarioNombre
     */
    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    /**
     * @param UsuarioNombre the UsuarioNombre to set
     */
    public void setUsuarioNombre(String UsuarioNombre) {
        this.usuarioNombre = UsuarioNombre;
    }

    /**
     * @return the usuarioNik
     */
    public String getUsuarioNik() {
        return usuarioNik;
    }

    /**
     * @param usuarioNik the usuarioNik to set
     */
    public void setUsuarioNik(String usuarioNik) {
        this.usuarioNik = usuarioNik;
    }

    /**
     * @return the Usuarioclave
     */
    public String getUsuarioclave() {
        return Usuarioclave;
    }

    /**
     * @param Usuarioclave the Usuarioclave to set
     */
    public void setUsuarioclave(String Usuarioclave) {
        this.Usuarioclave = Usuarioclave;
    }
     @Override
    public String toString() {
        return " id: " + idUsuario
                + " UsuarioNombre: " + usuarioNombre
                + " usuarioNik: " + usuarioNik
                + " Usuarioclave: " + Usuarioclave;
    }
}
