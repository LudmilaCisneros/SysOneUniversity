package AFA.Controllers;

import AFA.DTOs.DTO_Equipo;
import AFA.Services.Serv_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;
/*
    @GetMapping("/ver")//ALL
    public String getEquipos() {
        return "hola";

    }*/
    @GetMapping("/ver")//ALL
    public List<DTO_Equipo> getEquipos() {
        return servEquipo.obtenerEquipos();

    }
    /*
    @GetMapping("/ver/{CUIT}")
    public DTO_Equipo getEquipo(@PathVariable int cuitEquipo){
        return servEquipo.obtenerEquipo(cuitEquipo);
    }

    @PostMapping("/insertar")
    public void postEquipo(@RequestBody DTO_Equipo dtoEquipo){
        servEquipo.insertarEquipo(dtoEquipo);
    }

    @PutMapping("/modificar/{CUIT}")
    public void putEquipo(@PathVariable int cuitEquipo, @RequestBody DTO_Equipo dtoEquipo) {
        servEquipo.modificarEquipo(cuitEquipo, dtoEquipo);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteEquipo(@PathVariable int cuitEquipo) {
        servEquipo.eliminarEquipo(cuitEquipo);
    }
    */
}