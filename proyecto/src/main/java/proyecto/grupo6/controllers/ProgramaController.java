package proyecto.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import proyecto.grupo6.entities.LineaProyecto;
import proyecto.grupo6.entities.Programa;
import proyecto.grupo6.services.ProgramaService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/programa")
@CrossOrigin( "*")
public class ProgramaController {


    @Autowired
    private ProgramaService programaService;



    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('Crear_Programa')")
    @Operation(summary = "Guarda un nuevo programa, requiere permiso Crear_Programa")
    public Programa save(@RequestBody Programa entity){
        return programaService.save(entity);
    }
    //read
    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAuthority('Leer_Programa_Id')")
    @Operation(summary = "Leer programa por Id, requiere el permiso Leer_Programa_Id")
    public Programa findById(@PathVariable long id){
        return programaService.findById(id);
    }
    //actualizar
    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('Programa_Actualizar')")
    @Operation(summary = "Actualiza todos los programas, requiere el permiso Programa_Actualizar")
    public Programa update(@RequestBody Programa entity) {
        return programaService.save(entity);
    }

    @PatchMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('Programa_Actualizar_Id')")
    @Operation(summary = "Actualiza programa por id, requiere el permiso Programa_Actualizar_Id")
    public Programa partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Programa programa = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Programa.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(programa, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
            }
        }
        return update(programa);
    }



//eliminar
    @DeleteMapping("eliminar/{id}")
    @PreAuthorize("hasAuthority('Programa_Eliminar_Id')")
    @Operation(summary = "Eliminar programa por id, requiere el permiso Programa_Eliminar_Id")
    public void delete(@PathVariable long id){
        Programa programa = programaService.findById(id);
        programaService.delete(programa);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('Programa_Leer')")
    @Operation(summary = "Obtiene todos los programas, requiere el permiso Programa_Leer")
    public List<Programa> findAll(){
        return (List<Programa>) programaService.findAll();
    }
}