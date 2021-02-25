package AFA.Entities;

import AFA.DTOs.DTO_Dt;

import javax.persistence.*;

@Entity
@Table(name = "dts")
public class Dt{
    //@GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_dt",nullable = false)
    private int id_dt;

    @Column(name = "nombre_equipo",nullable = false)
    private String clubDirigido;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @OneToOne(mappedBy = "dt")
    private Equipo equipo;

    public Dt(){    };

    public Dt(String nombre){
        this.nombre = nombre;
    }

    public Dt(String nombre,String clubDirigido){
        this.nombre = nombre;
        this.clubDirigido = clubDirigido;
    }
    public Dt(String clubDirigido, String nombre,int id_dt){
        this(nombre,clubDirigido);
        this.id_dt = id_dt;
    }

    public Dt(DTO_Dt dtoDt) {
        this.id_dt = dtoDt.getId_dt();
        this.clubDirigido = dtoDt.getClubDirigido();
        this.nombre = dtoDt.getNombre();
    }

    public int getId_dt() {
        return id_dt;
    }

    public void setId_dt(int id_dt) {
        this.id_dt = id_dt;
    }

    public String getClubDirigido() {
        return clubDirigido;
    }

    public void setClubDirigido(String clubDirigido) {
        this.clubDirigido = clubDirigido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }*/

}