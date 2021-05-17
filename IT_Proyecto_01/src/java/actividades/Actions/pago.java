/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades.Actions;

import com.opensymphony.xwork2.ActionSupport;
import gestionActividades.Usuario;
import gestionActividades.actividadesDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Laura
 */
public class pago extends ActionSupport{
    
    //VARIABLES DE PAGO
    private String metodoPago;
    private int id;
    private double importe, pagado;
    private Date fecha;
    private Set reservas;
    
    //VARIABLES GENERALES
    List<Usuario> lista = new ArrayList<>();    
    private actividadesDAO A = new actividadesDAO();
    
    public pago() {
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

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set getReservas() {
        return reservas;
    }

    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }
    
    
    public String execute() throws Exception {
        //Consultamos y devolvemos una lista con todos los pagos
        lista = A.consultaTodosPagos();
        return SUCCESS;
    }
    
}
