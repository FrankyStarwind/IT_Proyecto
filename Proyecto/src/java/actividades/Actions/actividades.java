/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Actividad;
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
public class actividades extends ActionSupport {
    
    //VARIABLES DE USUARIO    
    private Integer id;


     private Sede sede;
     private String nombre;
    
    //VARIABLES GENERALES

    private actividadesDAO A = new actividadesDAO();
    Actividad act = new Actividad();

    List<Actividad> lista = new ArrayList<>();
    public actividades() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public actividadesDAO getA() {
        return A;
    }

    public void setA(actividadesDAO A) {
        this.A = A;
    }

    public Actividad getAct() {
        return act;
    }

    public void setAct(Actividad act) {
        this.act = act;
    }

    public List<Actividad> getLista() {
        return lista;
    }

    public void setLista(List<Actividad> lista) {
        this.lista = lista;
    }
    
    public String execute() throws Exception {
        lista = A.consultaActividades();
        return SUCCESS;
    }
    
}
