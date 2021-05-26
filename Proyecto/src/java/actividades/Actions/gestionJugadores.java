/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Equipo;
import gestionActividades.Jugador;
import gestionActividades.equiposDAO;
import gestionActividades.jugadoresDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class gestionJugadores extends ActionSupport {

    private int id;
    private String nombre;
    private int edad;
    private int dorsal;
    private int idEquipoFK;

    private jugadoresDAO jugadoresDAO = new jugadoresDAO();
    private List<Jugador> listaJugadores = new ArrayList<>();

    private equiposDAO equipoDAO = new equiposDAO();

    public gestionJugadores() {
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getIdEquipoFK() {
        return idEquipoFK;
    }

    public void setIdEquipoFK(int idEquipoFK) {
        this.idEquipoFK = idEquipoFK;
    }

    public jugadoresDAO getJugadoresDAO() {
        return jugadoresDAO;
    }

    public void setJugadoresDAO(jugadoresDAO jugadoresDAO) {
        this.jugadoresDAO = jugadoresDAO;
    }

    @Override
    public String execute() throws Exception {
        listaJugadores = jugadoresDAO.consultaTodosJugadores();

        System.out.println("Funciona");
        return SUCCESS;
    }

    /**
     * Elimina un jugador
     *
     * @param j
     * @return
     * @throws Exception
     */
    public String eliminarJugador() throws Exception {
        Equipo p = (Equipo) equipoDAO.busquedaEquipoPorId(idEquipoFK);

        Jugador j = new Jugador(p, nombre, edad, dorsal);
        jugadoresDAO.eliminarJugador(j);
        listaJugadores = jugadoresDAO.consultaTodosJugadores();

        return SUCCESS;
    }

    public String editarJugador() throws Exception {

        Equipo p = (Equipo) equipoDAO.busquedaEquipoPorId(idEquipoFK);

        Jugador j = new Jugador(p, nombre, edad, dorsal);
        jugadoresDAO.editarJugador(j);
        listaJugadores = jugadoresDAO.consultaTodosJugadores();

        return SUCCESS;
    }
    /**
     * public String visualizarJugador() { listaJugadores =
     * jugadoresDAO.busquedaJugadorPorNombreDorsal(nombre, dorsal); return
     * SUCCESS;
     *
     * }
     * *
     */
}
