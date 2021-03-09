package AFA.Controllers;

import AFA.DTOs.DTO_Equipo;
import AFA.Services.Serv_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/equipo")
@RestController
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;

    @GetMapping(value = {"/ver","/ver/{cuitEquipo}"})
    public List<DTO_Equipo> getEquipo(@PathVariable(required = false) Integer cuitEquipo){
        List<DTO_Equipo> list = new ArrayList<>();

        if(cuitEquipo != null){
            list.add(servEquipo.obtenerEquipo(cuitEquipo));
        }
        else{
            list = servEquipo.obtenerEquipos();
        }

        return list;
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