/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Actividad;
import gestionActividades.Equipo;
import gestionActividades.Pago;
import gestionActividades.Reserva;
import gestionActividades.Sede;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Laura
 */
public class reserva extends ActionSupport {

    private Integer id;
    private Pago pago;
    private Usuario usuario;
    private Actividad actividad;
    private Equipo idEquipoDosFK;
     private Equipo idEquipoUnoFK;
    
    private Date fecha;

    //VARIABLES GENERALES
    List<Reserva> listaReserva = new ArrayList<>();
      List<Actividad> listaAc = new ArrayList<>();

    Usuario usu = new Usuario();
    Map session = (Map) ActionContext.getContext().get("session");

    private actividadesDAO a = new actividadesDAO();

    public Map getSession() {
        return session;
    }

    public Equipo getIdEquipoDosFK() {
        return idEquipoDosFK;
    }

    public void setIdEquipoDosFK(Equipo idEquipoDosFK) {
        this.idEquipoDosFK = idEquipoDosFK;
    }

    public Equipo getIdEquipoUnoFK() {
        return idEquipoUnoFK;
    }

    public void setIdEquipoUnoFK(Equipo idEquipoUnoFK) {
        this.idEquipoUnoFK = idEquipoUnoFK;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String listaReserva() {
        listaReserva = a.consultalistaReserva();
        listaAc = a.consultaActividades();
        return SUCCESS;
    }

    public String altaReserva() throws Exception {
        Reserva re = new Reserva(pago, usuario, fecha, actividad,idEquipoUnoFK,idEquipoDosFK);
        a.insertarReserva(re);
        return SUCCESS;
    }

    public String eliminarReserva() throws Exception {

        a.eliminarReserva(id);
        listaReserva = a.consultalistaReserva();

        return SUCCESS;
    }

    public String editReserva() throws Exception {

        listaReserva = a.buscarlistaReserva(id);

        return SUCCESS;
    }

    public String editReservaF() throws Exception {
        Reserva r = new Reserva(id, pago, usuario, fecha, actividad);

        a.editarReserva(r);

        listaReserva = a.consultalistaReserva();

        return SUCCESS;
    }
}
