/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Sede;
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
public class controlador extends ActionSupport {

    //VARIABLES DE USUARIO    
    private String userName, password, nombre, apellidos, dni, email, tlf;
    private double admin;
    private Set reservas;
    private int id;

    
    //VARIABLES GENERALES

    private actividadesDAO A = new actividadesDAO();
    Usuario usu = new Usuario();
    Map session = (Map) ActionContext.getContext().get("session");

    List<Usuario> lista = new ArrayList<>();
    private actividadesDAO a = new actividadesDAO();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }






    public controlador() {
    }


    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public actividadesDAO getA() {
        return A;
    }

    public void setA(actividadesDAO A) {
        this.A = A;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
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

    /**
     *
     * @return @throws Exception
     */
    @Override
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
        session.put("admin", null);
        session.put("nombre", null);

        return SUCCESS;
    }

}
