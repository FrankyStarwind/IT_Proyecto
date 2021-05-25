/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Laura
 */
public class login extends ActionSupport{
    
    Map session = (Map) ActionContext.getContext().get("session");

    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    
    List<Usuario> lista = new ArrayList<>();
    private actividadesDAO a = new actividadesDAO();

    public login() {
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

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public actividadesDAO getA() {
        return a;
    }

    public void setA(actividadesDAO a) {
        this.a = a;
    }

    public String execute() throws Exception {
        Usuario u = a.login(this.getDni(), this.getPassword());
        if(u != null){
            if(u.getAdmin() == 1){ // si es administrador
                session.put("usuario", null);
                session.put("administrador", u.getNombre() + " " + u.getApellidos());
            }
            if(u.getAdmin() == 0){ // si no es administrador
                session.put("administrador", null);
                session.put("usuario", u.getNombre() + " " + u.getApellidos());
            }
            session.put("dni", u.getDni());
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

}
