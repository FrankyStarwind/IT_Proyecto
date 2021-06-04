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
    private Integer idSede;
    private Sede sede;
    private String nombre;
    private String nombreActividad;
    private int activo;
  private Double precio;
   private List<Sede> listaSede;

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public List<Sede> getListaSede() {
        return listaSede=a.consultaSedes();
    }

    public void setListaSede(List<Sede> listaSede) {
        this.listaSede = listaSede;
    }
  
  
  
    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
  

    //VARIABLES GENERALES
    private actividadesDAO a = new actividadesDAO();
    Actividad act = new Actividad();

    List<Actividad> lista = new ArrayList<>();

    public actividades() {
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public String listaActividades() throws Exception {
        lista = a.consultaActividades();
        return SUCCESS;
    }

    public String altaActividad() throws Exception {
        sede = a.buscarSede(idSede).get(0);
        Actividad ac = new Actividad(sede, nombre, precio, 1);
        a.insertarActividad(ac);
        lista = a.consultaActividades();
        return SUCCESS;
    }

    public String desactivarActividad() throws Exception {
        
        Actividad actividad = a.buscarACtividadId(id).get(0);
        Actividad ac = new Actividad(actividad.getId(), actividad.getSede(), actividad.getNombre(), actividad.getPrecio(), 0);
        a.desactivarActividad(ac);
        lista = a.consultaActividades();

        return SUCCESS;
    }

    public String editActividad() throws Exception {

        lista = a.buscarACtividadId(id);

        return SUCCESS;
    }

    public String editActividadF() throws Exception {
         sede = a.buscarSede(idSede).get(0);
        Actividad ac = new Actividad(id, sede, nombre, precio, activo);

        a.editarActividad(ac);

        lista = a.consultaActividades();

        return SUCCESS;
    }

    public String buscarActividad() {

        lista = a.buscarActividadNombreFiltro(nombreActividad);
        nombreActividad = "";
        return SUCCESS;
    }

}
