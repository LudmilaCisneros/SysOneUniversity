package AFA.Controllers;

import AFA.DTOs.DTO_Equipo;
import AFA.Exceptions.BadRequestException;
import AFA.Exceptions.NotFoundException;
import AFA.ServicesImp.Serv_Equipo;
import AFA.Validators.Validator_Dt;
import AFA.Validators.Validator_Equipo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/equipos")
@RestController
public class Ctrl_Equipo {
    @Autowired
    Serv_Equipo servEquipo;

    @GetMapping(value = {"/","/{cuitEquipo}"})
    public List<DTO_Equipo> getEquipo(@PathVariable(required = false) Integer cuitEquipo) throws NotFoundException {
        List<DTO_Equipo> list = new ArrayList<>();

        if(cuitEquipo != null){
            try{
                list.add(servEquipo.obtenerEquipo(cuitEquipo));
            }catch (RuntimeException e){
                throw new NotFoundException("Cuit " + cuitEquipo + " no encontrado");
            }
        }
        else{
            list = servEquipo.obtenerEquipos();
        }

        return list;
    }

    @PostMapping("/")
    public void postEquipo(@RequestBody @Valid DTO_Equipo dtoEquipo, BindingResult result) throws BadRequestException {
        new Validator_Equipo().validate(dtoEquipo,result);

        if(!result.hasErrors()){
            try{
                servEquipo.insertarEquipo(dtoEquipo);
            }catch (RuntimeException e){
                throw new BadRequestException("El dt no existe");
            }
        }else {
            throw new BadRequestException("El equipo es incorrecto");
        }
    }

    @DeleteMapping("/{cuitEquipo}")
    public void deleteEquipo(@PathVariable Integer cuitEquipo) throws NotFoundException{
        if(cuitEquipo != null){
            try{
                servEquipo.eliminarEquipo(cuitEquipo);
            }catch (RuntimeException e){
                throw new NotFoundException("Cuit " + cuitEquipo + " no encontrado");
            }
        }
    }

}