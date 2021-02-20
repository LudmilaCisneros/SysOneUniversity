package Entities;

import javax.persistence.*;

@Entity
@Table(name = "dts")
public class Dt{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idDt;

    @Column(name = "nombreEquipo")
    private String clubDirigido;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "dni",referencedColumnName = "idDt")
    private Equipo equipo;

    public Dt(){    };

    public Dt(String nombre){
        this.nombre = nombre;
    }

    public Dt(String nombre,String clubDirigido){
        this.nombre = nombre;
        this.clubDirigido = clubDirigido;
    }
    public Dt(String clubDirigido, String nombre,int idDt){
        this(nombre,clubDirigido);
        this.idDt = idDt;
    }

    public String getClubDirigido() {
        return clubDirigido;
    }

    public int getIdDt() {
        return idDt;
    }

    public void setIdDt(int idDt) {
        this.idDt = idDt;
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
}