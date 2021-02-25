package AFA.Controllers;

import AFA.DTOs.DTO_Jugador;
import AFA.Services.Serv_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
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
/*
    @PutMapping("/borrar/{DNI}")
    public void putJugador(@PathVariable int dniJugador, @RequestBody DTO_Jugador dtoJugador) {
        servJugador.modificarJugador(dniJugador, dtoJugador);
    }

    @DeleteMapping("/jugador/{id}")
    public void deleteJugador(@PathVariable int dniJugador) {
        servJugador.eliminarJugador(dniJugador);
    }
*/
}
