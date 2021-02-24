package AFA.Services;

import AFA.DTOs.DTO_Equipo;

import java.util.List;

public interface IServ_Equipo {

    List<DTO_Equipo> obtenerEquipos();

    DTO_Equipo obtenerEquipo(int cuitEquipo);

    void insertarEquipo(DTO_Equipo dtoEquipo);

    void modificarEquipo(int cuitEquipo, DTO_Equipo dtoEquipo);

    void eliminarEquipo(int cuitEquipo);

}

