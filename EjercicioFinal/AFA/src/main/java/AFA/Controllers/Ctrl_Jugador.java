package AFA.Controllers;

import AFA.DTOs.DTO_Jugador;
import AFA.Services.Serv_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/jugador")
@RestController
public class Ctrl_Jugador {

    @Autowired
    Serv_Jugador servJugador;

    @GetMapping("/ver")//ALL
    public List<DTO_Jugador> getJugadores(){
        return servJugador.obtenerJugadores();
    }

    @GetMapping("/ver/{dniJugador}")
    public DTO_Jugador getJugador(@PathVariable int dniJugador){
    return servJugador.obtenerJugador(dniJugador);
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
