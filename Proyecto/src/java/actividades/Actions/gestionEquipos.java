/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Equipo;
import gestionActividades.Jugador;
import gestionActividades.equiposDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class gestionEquipos extends ActionSupport {

    private int id;
    private String nombre;
    private int activo;

    private int idEquipoFK;

    private equiposDAO equiposDAO = new equiposDAO();
    private List<Equipo> listaEquipos = new ArrayList<>();

    public gestionEquipos() {
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEquipoFK() {
        return idEquipoFK;
    }

    public void setIdEquipoFK(int idEquipoFK) {
        this.idEquipoFK = idEquipoFK;
    }

    public equiposDAO getEquiposDAO() {
        return equiposDAO;
    }

    public void setEquiposDAO(equiposDAO equiposDAO) {
        this.equiposDAO = equiposDAO;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @Override
    public String execute() throws Exception {
        listaEquipos = equiposDAO.consultaTodosLosEquipos();

        System.out.println("Funciona");
        return SUCCESS;
    }
    public String altaEquipoF() throws Exception{
        Equipo equipo = new Equipo(nombre,1);
        equiposDAO.crearEquipo(equipo);
           listaEquipos = equiposDAO.consultaTodosLosEquipos();
        return SUCCESS;
    }

    public String desactivarEquipo() throws Exception {
                Equipo eq = equiposDAO.busquedaEquipoPorId(id);
        Equipo equipo = new Equipo(eq.getId(),eq.getNombre(),0);
        
        equiposDAO.desactivarEquipo(equipo);
   


        listaEquipos = equiposDAO.consultaTodosLosEquipos();

        return SUCCESS;
    }
    
    public String editEquipo() throws Exception {

        listaEquipos = equiposDAO.busquedaUsuarioPorID(id);

        return SUCCESS;
    }
    
    public String editEquipoF() throws Exception {
                    
        Equipo equipo = new Equipo(id,nombre,activo);
        equiposDAO.editarEquipo(equipo);

        listaEquipos = equiposDAO.consultaTodosLosEquipos();
        return SUCCESS;
    }
    
    public String buscarEquipo(){
        
       listaEquipos = equiposDAO.buscarEquipoNombre(nombre);
        return SUCCESS;
    }
}
