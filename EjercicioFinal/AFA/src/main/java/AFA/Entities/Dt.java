package AFA.Entities;

import javax.persistence.*;

@Entity
@Table(name = "dts")
public class Dt{
    @Id
    @Column(name = "id_dt",nullable = false)
    private int id_dt;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)//
    @JoinColumn(name = "cuit_equipo", referencedColumnName = "cuit_equipo")
    private Equipo equipo;

    public Dt(){    };

    public Dt(String nombre){
        this.nombre = nombre;
    }
    public Dt( String nombre,int id_dt){
        this(nombre);
        this.id_dt = id_dt;
    }

    public int getId_dt() {
        return id_dt;
    }

    public void setId_dt(int id_dt) {
        this.id_dt = id_dt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}