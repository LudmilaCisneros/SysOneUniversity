package AFA.Controllers;

import AFA.DTOs.DTO_Equipo;
import AFA.Services.Serv_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/equipo")
@RestController
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;

    @GetMapping("/ver")//ALL
    public List<DTO_Equipo> getEquipos() {
        return servEquipo.obtenerEquipos();
    }

    @GetMapping("/ver/{cuitEquipo}")
    public DTO_Equipo getEquipo(@PathVariable int cuitEquipo){
        return servEquipo.obtenerEquipo(cuitEquipo);
    }

    @PostMapping("/insertar")
    public void postEquipo(@RequestBody DTO_Equipo dtoEquipo){
        servEquipo.insertarEquipo(dtoEquipo);
    }

    @DeleteMapping("/borrar/{cuitEquipo}")
    public void deleteEquipo(@PathVariable int cuitEquipo) {
        servEquipo.eliminarEquipo(cuitEquipo);
    }
}