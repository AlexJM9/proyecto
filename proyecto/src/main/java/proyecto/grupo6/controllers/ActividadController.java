package proyecto.grupo6.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import proyecto.grupo6.entities.Actividad;
import proyecto.grupo6.services.ActividadService;



@RestController
@RequestMapping("api/actividad")
@CrossOrigin("*")
@Tag( name = " Actividad( Tabla Actividad)")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PreAuthorize("hasAuthority('Crear_Actividad')")
    @PostMapping("/crear")
    @Operation(summary = "Guarda una nueva actividad, requiere permiso Crear_Actividad")
    public Actividad save(@RequestBody Actividad entity) {
        return actividadService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAuthority('Leer_Actividad_Id')")
    @Operation(summary = "Leer actividad por Id, requiere el permiso Leer_Actividad_Id")
    public Actividad findById(@PathVariable long id) {
        return actividadService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('Actividad_Leer')")
    @Operation(summary = "Obtiene todos las actividades, requiere el permiso Actividad_Leer")
    public List<Actividad> findAll() {
        return actividadService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('Actividad_Actualizar')")
    @Operation(summary = "Actualiza todas las actividades, requiere el permiso Actividad_Actualizar")
    public Actividad update(@RequestBody Actividad entity) {
        return actividadService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('Actividad_Actualizar_Id')")
    @Operation(summary = "Actualiza actividad por id, requiere el permiso Actividad_Actualizar_Id")
    public Actividad partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Actividad actividad = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Actividad.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(actividad, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(actividad);
    }

    // eliminar
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('Actividad_Eliminar_Id')")
    @Operation(summary = "Eliminar actividad por id, requiere el permiso Actividad_Eliminar_Id")
    public void deleteById(@PathVariable long id) {
        actividadService.deleteById(id);
    }

}