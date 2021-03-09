package AFA.Controllers;

import AFA.DTOs.DTO_Jugador;
import AFA.ServicesImp.Serv_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/jugadores")
@RestController
public class Ctrl_Jugador {

    @Autowired
    Serv_Jugador servJugador;

    @GetMapping(value = {"/","/{dniJugador}"})
    public List<DTO_Jugador> getJugador(@PathVariable(required = false) Integer dniJugador){
        List<DTO_Jugador> list = new ArrayList<>();

        if(dniJugador != null){
            list.add(servJugador.obtenerJugador(dniJugador));
        }
        else{
            list = servJugador.obtenerJugadores();
        }

        return list;
    }

    @PostMapping("/insertar")
    public void postJugador(@RequestBody DTO_Jugador dtoJugador){
        servJugador.insertarJugador(dtoJugador);
    }

    @DeleteMapping("/borrar/{dniJugador}")
    public void deleteJugador(@PathVariable int dniJugador) {
        servJugador.eliminarJugador(dniJugador);
    }
}
