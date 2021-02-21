package Controllers;

import DTOs.DTO_Jugador;
import Services.Serv_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Jugador")

public class Ctrl_Jugador {
    @Autowired
    Serv_Jugador servJugador;

    @GetMapping("/jugador/{id}")
    public DTO_Jugador getJugador(@PathVariable int dniJugador) {
        return servJugador.obtenerJugador(dniJugador);
    }

    @PostMapping("/jugador")
    public void postJugador(@RequestBody DTO_Jugador dtoJugador) {
        servJugador.insertarJugador(dtoJugador);
    }

    @PutMapping("/jugador/{id}")
    public void putJugador(@PathVariable int dniJugador, @RequestBody DTO_Jugador dtoJugador) {
        servJugador.modificarJugador(dniJugador, dtoJugador);
    }

    @DeleteMapping("/jugador/{id}")
    public void deleteJugador(@PathVariable int dniJugador) {
        servJugador.eliminarJugador(dniJugador);
    }

}
