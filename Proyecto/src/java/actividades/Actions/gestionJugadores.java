/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Equipo;
import gestionActividades.Jugador;
import gestionActividades.actividadesDAO;
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
    private Equipo equipo;
        private Integer idEq1;
    
          private List<Equipo> listaEq1;
    private jugadoresDAO jugadoresDAO = new jugadoresDAO();
    private List<Jugador> listaJugadores = new ArrayList<>();
    private List<Equipo> listaEquipos = new ArrayList<>();
    
    private equiposDAO equipoDAO = new equiposDAO();
    


    public gestionJugadores() {
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public List<Equipo> getListaEq1() {
        return listaEq1= equipoDAO.consultaTodosLosEquipos();
    }

    public void setListaEq1(List<Equipo> listaEq1) {
        this.listaEq1 = listaEq1;
    }

    public int getId() {
        return id;
    }

    public Integer getIdEq1() {
        return idEq1;
    }

    public void setIdEq1(Integer idEq1) {
        this.idEq1 = idEq1;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public equiposDAO getEquipoDAO() {
        return equipoDAO;
    }

    public void setEquipoDAO(equiposDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
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
        System.out.println("La id es "+id);
        jugadoresDAO.eliminarJugador(id+"");
        listaJugadores = jugadoresDAO.consultaTodosJugadores();

        return SUCCESS;
    }

    
    public String editarJugador() throws Exception {
        
    listaJugadores =  jugadoresDAO.busquedaJugadorPorId(id);
      
        return SUCCESS;
    }

    public String editarJugadorF() throws Exception{
        
        Equipo p = (Equipo) equipoDAO.busquedaEquipoPorId(idEq1);

        Jugador j = new Jugador(id,p, nombre, edad, dorsal);
        jugadoresDAO.editarJugador(j);
        
        listaJugadores = jugadoresDAO.consultaTodosJugadores();
        return SUCCESS;
    }
    public String altaJugador() throws Exception {
        
        equipo= equipoDAO.busquedaEquipoPorId(idEq1);
        

        Jugador p = new Jugador(equipo,nombre,edad,dorsal);
        jugadoresDAO.insertarJugador(p);
      
        execute();
        return SUCCESS;
    }
    public String buscarJugador(){
        
       listaJugadores = jugadoresDAO.busquedaJugadorPorNombreDorsal(nombre);
       nombre="";
        return SUCCESS;
    }
  
}
