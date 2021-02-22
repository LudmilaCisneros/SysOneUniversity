package Controllers;

import DTOs.DTO_Equipo;
import Services.Serv_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipo")
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;

    @GetMapping("/ver")
    public List<DTO_Equipo> getEquipos(){
        return servEquipo.obtenerEquipos();
    }

    @GetMapping("/ver/{CUIT}")
    public DTO_Equipo getEquipo(@RequestParam(name = "CUIT") int cuitEquipo){
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

}