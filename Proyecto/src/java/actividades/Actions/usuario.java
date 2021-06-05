/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class usuario extends ActionSupport {

    //VARIABLES DE USUARIO 
    private String userName;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String tlf;
    private double admin;

    private String adminS;
    private Integer idBuscar;

    //VARIABLES GENERALES
    List<Usuario> lista = new ArrayList<>();
    private actividadesDAO a = new actividadesDAO();

    public usuario() {
    }

    public String getAdminS() {
        return adminS;
    }

    public void setAdminS(String adminS) {
        this.adminS = adminS;
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

    public String altaUsuario() throws Exception {
        if (adminS.equals("Si")) {
            admin = 1;
        } else {
            admin = 0;
        }
        Usuario usu = new Usuario(userName, password, nombre, apellidos, dni, email, tlf, admin);
        a.insertarUsuario(usu);

        lista = a.consultaTodosUsuarios();
        return SUCCESS;
    }

    public String eliminarUsuario() throws Exception {

        a.eliminarUsuario(dni);
        lista = a.consultaTodosUsuarios();

        return SUCCESS;
    }

    public Integer getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(Integer idBuscar) {
        this.idBuscar = idBuscar;
    }

    public String buscarUsuario() throws Exception {

        lista = a.busquedaUsuarioPorDni(this.getDni());
        dni = "";
        return SUCCESS;
    }

    public String editUsuario() throws Exception {

        lista = a.busquedaUsuarioPorDni(dni);
        idBuscar = null;
        return SUCCESS;
    }

    public String editUsuarioF() throws Exception {
        if (adminS.equals("Si") || adminS.equals("1.0")) {
            admin = 1;
        } else {
            admin = 0;
        }
        Usuario usu = new Usuario(userName, password, nombre, apellidos, dni, email, tlf, admin);
        a.editarUsuario(usu);

        lista = a.consultaTodosUsuarios();
        return SUCCESS;
    }

    public String execute() throws Exception {
        //Consultamos y devolvemos una lista con todos los usuarios
        lista = a.consultaTodosUsuarios();
        return SUCCESS;
    }

}
