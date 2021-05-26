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

    private int idEquipo;
    private String nombre;
    
    private int idEquipoFK;

    private equiposDAO equiposDAO = new equiposDAO();
    private List<Equipo> listaEquipos = new ArrayList<>();

    public gestionEquipos() {
    }

      

    @Override
    public String execute() throws Exception {
        listaEquipos = equiposDAO.consultaTodosLosEquipos();
        
        System.out.println("Funciona");
        return SUCCESS;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
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

    public String eliminarJugador() throws Exception {
        equiposDAO.eliminarEquipo(idEquipo);
        listaEquipos = equiposDAO.consultaTodosLosEquipos();

        return SUCCESS;
    }
}
