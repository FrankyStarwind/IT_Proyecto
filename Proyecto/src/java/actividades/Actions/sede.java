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
public class sede extends ActionSupport {

    //VARIABLES DE SEDE    
    private String nombre, email, tlf;

    private int id;

    private String direccion;
    private int cp;
    private int activo;

    private String provincia;

    private String nombreSede;

    //VARIABLES GENERALES
    List<Sede> listaSede = new ArrayList<>();
    private actividadesDAO A = new actividadesDAO();

    Usuario usu = new Usuario();
    Map session = (Map) ActionContext.getContext().get("session");

    private actividadesDAO a = new actividadesDAO();

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public sede() {
    }

    public List<Sede> getListaSede() {
        return listaSede;
    }

    public void setListaSede(List<Sede> listaSede) {
        this.listaSede = listaSede;
    }

    public actividadesDAO getA() {
        return A;
    }

    public void setA(actividadesDAO A) {
        this.A = A;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String listaSede() {
        listaSede = A.consultaSedes();
        return SUCCESS;
    }

    public String altaSede() throws Exception {
        Sede se = new Sede(nombre, direccion, cp, tlf, email, provincia, 1);
        a.insertarSede(se);
        return SUCCESS;
    }

    public String desactivarSede() throws Exception {
        Sede sede = a.buscarSede(id).get(0);
        Sede se = new Sede(sede.getId(), sede.getNombre(), sede.getDireccion(), sede.getCp(), sede.getTlf(), sede.getEmail(), sede.getProvincia(), 0);
        a.desactivarSede(se);

        listaSede = a.consultaSedes();

        return SUCCESS;
    }

    public String editSede() throws Exception {

        listaSede = a.buscarSede(id);

        return SUCCESS;
    }

    public String editSedeF() throws Exception {
        Sede s = new Sede(id, nombre, direccion, cp, tlf, email, provincia, activo);
        System.out.println(s);
        a.editarSede(s);

        listaSede = a.consultaSedes();

        return SUCCESS;
    }

    public String buscarSede() {

        listaSede = a.buscarSedeNombre(nombreSede);
        nombreSede = "";
        return SUCCESS;
    }
}
