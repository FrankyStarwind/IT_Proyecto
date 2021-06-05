/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Pago;
import gestionActividades.Reserva;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Laura
 */
public class pago extends ActionSupport {

    //VARIABLES DE PAGO
    private List<String> listaPago;

    
    private String metodoPago;
    private int id, pagado, idReservaFk;
    private double importe;
    private Date fechaD;
    Map session = (Map) ActionContext.getContext().get("session");


    

    //VARIABLES GENERALES
    List<Pago> lista = new ArrayList<>();
    private actividadesDAO A = new actividadesDAO();
    private String fecha;
    private String pagadoS;
    private Integer idBuscar;
    
    Reserva res = new Reserva();
    private String reservaUsuario;

    public List<String> getListaPago() {
          listaPago = new ArrayList<String>();
        listaPago.add("PAYPAL");
        listaPago.add("TARJETA");
        listaPago.add("BIZUM");
        return listaPago;
    }

    public void setListaPago(List<String> listaPago) {
        this.listaPago = listaPago;
    }

    public pago() {
    }

    public Integer getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(Integer idBuscar) {
        this.idBuscar = idBuscar;
    }

    public int getIdReservaFK() {
        return idReservaFk;
    }

    public void setIdReservaFK(int idReservaFK) {
        this.idReservaFk = idReservaFK;
    }

    public int getIdReservaFk() {
        return idReservaFk;
    }

    public void setIdReservaFk(int idReservaFk) {
        this.idReservaFk = idReservaFk;
    }

    public Reserva getRes() {
        return res;
    }

    public void setRes(Reserva res) {
        this.res = res;
    }

    public String getReservaUsuario() {
        return reservaUsuario;
    }

    public void setReservaUsuario(String reservaUsuario) {
        this.reservaUsuario = reservaUsuario;
    }

    public String getPagadoS() {
        return pagadoS;
    }

    public void setPagadoS(String pagadoS) {
        this.pagadoS = pagadoS;
    }

    public List<Pago> getLista() {
        return lista;
    }

    public void setLista(List<Pago> lista) {
        this.lista = lista;
    }

    public actividadesDAO getA() {
        return A;
    }

    public void setA(actividadesDAO A) {
        this.A = A;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    public Date getFechaD() {
        return fechaD;
    }

    public void setFechaD(Date fechaD) {
        this.fechaD = fechaD;
    }

    public Date ParseFecha(String fecha) throws java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        fechaD = formato.parse(fecha);
        return fechaD;
    }

    public String visualizarPagosUsuario() throws Exception {
        //Consultamos y devolvemos los datos del usuario
        Usuario usuario = A.busquedaUsuarioPorDni((String) session.get("dni")).get(0);
        List<Reserva> listaReservas = A.buscarReservaUserName(usuario.getUserName());
   
      
        lista = A.buscarPagoPorUsuario(listaReservas);
        
        return SUCCESS;
    }

    public String eliminarPago() throws Exception {

        A.eliminarPago(id);
        lista = A.consultaTodosPagos();

        return SUCCESS;
    }

    public String buscarPago() throws Exception {

        lista = A.busquedaPagoPorId(idBuscar);
        idBuscar = null;
        return SUCCESS;
    }

    public String editPago() throws Exception {

        lista = A.busquedaPagoPorId(this.getId());

        return SUCCESS;
    }

    public String editPagoF() throws Exception {

        ParseFecha(fecha);
        Pago p = A.busquedaPagoPorId(id).get(0);
        res = A.buscarReservaPorIdReservaFK(p.getReserva().getId()).get(0);
        Pago pago = new Pago(id, metodoPago, importe, pagado, fechaD,res);
        A.editarPago(pago);

        lista = A.consultaTodosPagos();
        return SUCCESS;
    }

    public String execute() throws Exception {
        //Consultamos y devolvemos una lista con todos los pagos
        lista = A.consultaTodosPagos();
        return SUCCESS;
    }

}
