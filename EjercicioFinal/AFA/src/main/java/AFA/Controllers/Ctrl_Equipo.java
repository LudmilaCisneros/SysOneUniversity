package AFA.Controllers;

import AFA.DTOs.DTO_Equipo;
import AFA.ServicesImp.Serv_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/equipos")
@RestController
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;

    @GetMapping(value = {"/","/{cuitEquipo}"})
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

    @PostMapping("/")
    public void postEquipo(@RequestBody DTO_Equipo dtoEquipo){
        servEquipo.insertarEquipo(dtoEquipo);
    }

    @DeleteMapping("/{cuitEquipo}")
    public void deleteEquipo(@PathVariable int cuitEquipo) {
        servEquipo.eliminarEquipo(cuitEquipo);
    }
}