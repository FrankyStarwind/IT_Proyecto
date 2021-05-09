/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Laura
 */
public class controlador {

    //VARIABLES DE USUARIO    
    String userName, password, nombre, apellidos, dni, email, tlf;
    double admin;
    Set reservas;

    //VARIABLES GENERALES
    List lista = new ArrayList();
    actividadesDAO A = new actividadesDAO();
    Usuario usu = new Usuario();
    Map session = (Map) ActionContext.getContext().get("session");

    public controlador() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public double getAdmin() {
        return admin;
    }

    public void setAdmin(double admin) {
        this.admin = admin;
    }

    public Set getReservas() {
        return reservas;
    }

    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }

    public String execute() throws Exception {
        //Consultamos y devolvemos una lista con todos los usuarios
        lista = A.consultaTodosUsuarios();
        return SUCCESS;
    }
    public String visualizarUsuario() throws Exception {
        //Consultamos y devolvemos los datos del usuario
        lista = A.busquedaUsuarioPorDni(this.getDni());

        return SUCCESS;
    }
    public String logout() throws Exception {

        //Dejamos las sesiones vacías
        session.put("administrador", null);
        session.put("usuario", null);

        return SUCCESS;
    }


}
