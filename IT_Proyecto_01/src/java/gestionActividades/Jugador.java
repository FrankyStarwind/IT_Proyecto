package gestionActividades;
// Generated 08-may-2021 10:30:32 by Hibernate Tools 4.3.1



/**
 * Jugador generated by hbm2java
 */
public class Jugador  implements java.io.Serializable {


     private Integer id;
     private Equipo equipo;
     private String nombre;
     private int edad;
     private int dorsal;

    public Jugador() {
    }

    public Jugador(Equipo equipo, String nombre, int edad, int dorsal) {
       this.equipo = equipo;
       this.nombre = nombre;
       this.edad = edad;
       this.dorsal = dorsal;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getDorsal() {
        return this.dorsal;
    }
    
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }




}

