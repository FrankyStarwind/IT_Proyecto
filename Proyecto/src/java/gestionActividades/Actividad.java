package gestionActividades;
// Generated 16-may-2021 10:37:05 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Actividad generated by hbm2java
 */
public class Actividad  implements java.io.Serializable {


     private Integer id;

private Double precio;
     private Sede sede;
     private String nombre;
 
    

    public Actividad() {
    }


    public Actividad(Sede sede, String nombre,Double precio) {

this.precio=precio;
       this.sede = sede;
       this.nombre = nombre;

    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Sede getSede() {
        return this.sede;
    }
    
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    




}


