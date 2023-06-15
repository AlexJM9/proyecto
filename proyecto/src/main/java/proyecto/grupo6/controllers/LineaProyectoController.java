package proyecto.grupo6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import proyecto.grupo6.entities.Actividad;
import proyecto.grupo6.entities.LineaProyecto;
import proyecto.grupo6.services.LineaProyectoService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("api/linea")
@CrossOrigin( "*")
public class LineaProyectoController {


    @Autowired
    private LineaProyectoService lineaProyectoService;



    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('Crear_Linea')")
    @Operation(summary = "Guarda una nueva linea, requiere permiso Crear_Linea")
    public LineaProyecto save(@RequestBody LineaProyecto entity){
        return lineaProyectoService.save(entity);
    }
    //read
    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAuthority('Leer_Linea_Id')")
    @Operation(summary = "Leer linea por Id, requiere el permiso Leer_Linea_Id")
    public LineaProyecto findById(@PathVariable long id){
        return lineaProyectoService.findById(id);
    }
    //actualizar
    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('Linea_Actualizar')")
    @Operation(summary = "Actualiza todas las lineas, requiere el permiso Linea_Actualizar")
    public LineaProyecto update(@RequestBody LineaProyecto entity) {
        return lineaProyectoService.save(entity);
    }


        @PatchMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('Linea_Actualizar_Id')")
    @Operation(summary = "Actualiza linea por id, requiere el permiso Linea_Actualizar_Id")
    public LineaProyecto partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        LineaProyecto linea = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = LineaProyecto.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(linea, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(linea);
    }


    //eliminar
    @DeleteMapping("eliminar/{id}")  
    @PreAuthorize("hasAuthority('Linea_Eliminar_Id')")
    @Operation(summary = "Eliminar linea por id, requiere el permiso Linea_Eliminar_Id")
    public void delete(@PathVariable long id){
        LineaProyecto lineaProyecto = lineaProyectoService.findById(id);
        lineaProyectoService.delete(lineaProyecto);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('Linea_Leer')")
    @Operation(summary = "Obtiene todos las lineas, requiere el permiso Linea_Leer")
    public List<LineaProyecto> findAll(){
        return (List<LineaProyecto>) lineaProyectoService.findAll();
    }
}