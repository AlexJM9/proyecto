package proyectoinvestigacion.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import proyectoinvestigacion.proyecto.entities.LineaProyecto;
import proyectoinvestigacion.proyecto.services.LineaProyectoService;

import java.util.List;



@RestController
@RequestMapping("api/linea")
@CrossOrigin( "*")
public class LineaProyectoController {


    @Autowired
    private LineaProyectoService lineaProyectoService;



    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    @PostMapping("/crear")
    public LineaProyecto save(@RequestBody LineaProyecto entity){
        return lineaProyectoService.save(entity);
    }
    //read
    @GetMapping("/listar/{id}")
    public LineaProyecto findById(@PathVariable long id){
        return lineaProyectoService.findById(id);
    }
    //actualizar
    @PutMapping("/actualizar")
    public LineaProyecto update(@RequestBody LineaProyecto entity) {
        return lineaProyectoService.save(entity);
    }
    //eliminar
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable long id){
        LineaProyecto lineaProyecto = lineaProyectoService.findById(id);
        lineaProyectoService.delete(lineaProyecto);
    }

    @GetMapping("/listar")
    public List<LineaProyecto> findAll(){
        return (List<LineaProyecto>) lineaProyectoService.findAll();
    }
}