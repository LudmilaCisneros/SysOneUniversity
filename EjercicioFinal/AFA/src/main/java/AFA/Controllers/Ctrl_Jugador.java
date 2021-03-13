package AFA.Controllers;

import AFA.DTOs.DTO_Jugador;
import AFA.Exceptions.BadRequestException;
import AFA.Exceptions.NotFoundException;
import AFA.ServicesImp.Serv_Jugador;
import AFA.Validators.Validator_Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequestMapping("/jugadores")
@RestController
public class Ctrl_Jugador {

    @Autowired
    Serv_Jugador servJugador;

    @GetMapping(value = {"/","/{dniJugador}"})
    public List<DTO_Jugador> getJugador(@PathVariable(required = false) Integer dniJugador) throws NotFoundException {
        List<DTO_Jugador> list = new ArrayList<>();

        if(dniJugador != null){
            try{
                list.add(servJugador.obtenerJugador(dniJugador));
            }catch (RuntimeException e){
                throw new NotFoundException("Dni " + dniJugador + " no encontrado");
            }
        }
        else{
            list = servJugador.obtenerJugadores();
        }
        return list;
    }

    @PostMapping("/")
    public void postJugador(@RequestBody @Valid DTO_Jugador dtoJugador, BindingResult result) throws BadRequestException {
        new Validator_Jugador().validate(dtoJugador,result);
        if(!result.hasErrors()){
            servJugador.insertarJugador(dtoJugador);
        }else {
            throw new BadRequestException("El jugador es incorrecto");
        }
    }

    @DeleteMapping("/{dniJugador}")
    public void deleteJugador(@PathVariable Integer dniJugador) throws NotFoundException{
        if(dniJugador != null){
            try {
                servJugador.eliminarJugador(dniJugador);
            }catch (RuntimeException e){
                throw new NotFoundException("Dni " + dniJugador + " no encontrado");
            }
        }
    }
}
