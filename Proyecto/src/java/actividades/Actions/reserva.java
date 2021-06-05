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
import gestionActividades.equiposDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.mail.internet.ParseException;

/**
 *
 * @author Laura
 */
public class reserva extends ActionSupport {

    private Integer id;
    private Integer idActividad;
    private Integer idEq1;
    private Integer idEq2;
    private Pago pago;
    private Usuario usuario;
    private Actividad actividad;
    private Equipo idEquipoDosFK;
    private Equipo idEquipoUnoFK;
    private String fecha;
    private Date fechaD;

    private String nombreActividad;

    List<String> listaPago;

    private String tipoPago;

    //VARIABLES GENERALES
    List<Reserva> listaReserva = new ArrayList<Reserva>();
    private List<Actividad> listaAc;
    private List<Equipo> listaEq1;
    private List<Equipo> listaEq2;

    Usuario usu = new Usuario();
    Map session = (Map) ActionContext.getContext().get("session");

    private actividadesDAO a = new actividadesDAO();
    private equiposDAO b = new equiposDAO();

    public Date ParseFecha(String fecha) throws java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        fechaD = formato.parse(fecha);
        return fechaD;
    }

    public String getDefaultPago() {
        return "PAYPAL";
    }

    public List<String> getListaPago() {
        listaPago = new ArrayList<String>();
        listaPago.add("PAYPAL");
        listaPago.add("TARJETA");
        listaPago.add("BIZUM");
        return listaPago;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setListaPago(List<String> listaPago) {
        this.listaPago = listaPago;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdEq1() {
        return idEq1;
    }

    public void setIdEq1(Integer idEq1) {
        this.idEq1 = idEq1;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getIdEq2() {
        return idEq2;
    }

    public void setIdEq2(Integer idEq2) {
        this.idEq2 = idEq2;
    }

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

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public List<Equipo> getListaEq1() {
        return listaEq1 = b.consultaTodosLosEquipos();
    }

    public void setListaEq1(List<Equipo> listaEq1) {
        this.listaEq1 = listaEq1;
    }

    public List<Equipo> getListaEq2() {
        return listaEq2 = b.consultaTodosLosEquipos();
    }

    public void setListaEq2(List<Equipo> listaEq2) {
        this.listaEq2 = listaEq2;
    }

    public List<Actividad> getListaAc() {

        return listaAc = a.consultaActividades();
    }

    public void setListaAc(List<Actividad> listaAc) {
        this.listaAc = listaAc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getFechaD() {
        return fechaD;
    }

    public void setFechaD(Date fechaD) {
        this.fechaD = fechaD;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String listaReserva() {
        listaReserva = a.consultalistaReserva();

        return SUCCESS;
    }

    public String altaReserva() throws Exception {
        usuario = a.busquedaUsuarioPorDni((String) session.get("dni")).get(0);
        ParseFecha(fecha);
        actividad = a.buscarACtividadId(idActividad).get(0);
        idEquipoUnoFK = b.busquedaEquipoPorId(idEq1);
        idEquipoDosFK = b.busquedaEquipoPorId(idEq2);
        Reserva re = new Reserva(usuario, fechaD, actividad, idEquipoUnoFK, idEquipoDosFK);
        a.insertarReserva(re);

        Pago p = new Pago(tipoPago, actividad.getPrecio(), 1, new Date(), re);
        a.insertarPago(p);
        listaReserva();
        return SUCCESS;
    }

    public String eliminarReserva() throws Exception {
        pago = a.busquedaPagoPorReserva(id).get(0);
        a.eliminarPago(pago.getId());
        a.eliminarReserva(id);
        listaReserva = a.consultalistaReserva();

        return SUCCESS;
    }

    public String editReserva() throws Exception {

        listaReserva = a.buscarlistaReserva(id);

        idEquipoUnoFK = b.busquedaEquipoPorId(listaReserva.get(0).getEquipoByIdEquipoUnoFk().getId());
        idEquipoDosFK = b.busquedaEquipoPorId(listaReserva.get(0).getEquipoByIdEquipoDosFk().getId());

        return SUCCESS;
    }

    public String editReservaF() throws Exception {
        listaReserva = a.buscarlistaReserva(id);

        usuario = a.busquedaUsuarioPorDni((String) session.get("dni")).get(0);
        ParseFecha(fecha);
        idEquipoUnoFK = b.busquedaEquipoPorId(idEq1);
        idEquipoDosFK = b.busquedaEquipoPorId(idEq2);
        actividad = listaReserva.get(0).getActividad();
        Reserva re = new Reserva(listaReserva.get(0).getId(), usuario, fechaD, actividad, idEquipoUnoFK, idEquipoDosFK);

        a.editarReserva(re);

        listaReserva = a.consultalistaReserva();

        return SUCCESS;
    }

    public String buscarReserva() {

        actividad = a.buscarACtividadNombre(nombreActividad).get(0);

        listaReserva = a.buscarActidadReserva(actividad.getId());

        nombreActividad = "";
        return SUCCESS;
    }
}
