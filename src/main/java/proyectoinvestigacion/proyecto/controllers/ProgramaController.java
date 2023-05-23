package proyectoinvestigacion.proyecto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import proyectoinvestigacion.proyecto.entities.Programa;
import proyectoinvestigacion.proyecto.services.ProgramaService;

import java.util.List;


@RestController
@RequestMapping("api/programa")
@CrossOrigin( "*")
public class ProgramaController {


    @Autowired
    private ProgramaService programaService;



    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    @PostMapping("/crear")
    public Programa save(@RequestBody Programa entity){
        return programaService.save(entity);
    }
    //read
    @GetMapping("/listar/{id}")
    public Programa findById(@PathVariable long id){
        return programaService.findById(id);
    }
    //actualizar
    @PutMapping("/actualizar")
    public Programa update(@RequestBody Programa entity) {
        return programaService.save(entity);
    }
//eliminar
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable long id){
        Programa programa = programaService.findById(id);
        programaService.delete(programa);
    }

    @GetMapping("/listar")
    public List<Programa> findAll(){
        return (List<Programa>) programaService.findAll();
    }
}