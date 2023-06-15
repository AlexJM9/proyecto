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
import proyecto.grupo6.entities.Documento;
import proyecto.grupo6.services.DocumentoService;



@RestController
@RequestMapping("api/documento")
@CrossOrigin("*")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('Crear_Documento')")
    @Operation(summary = "Guarda una nuevo documento, requiere permiso Crear_Documento")
    public Documento save(@RequestBody Documento entity) {
        return documentoService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAuthority('Leer_Documento_Id')")
    @Operation(summary = "Leer documento por Id, requiere el permiso Leer_Documento_Id")
    public Documento findById(@PathVariable long id) {
        return documentoService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('Documento_Leer')")
    @Operation(summary = "Obtiene todos os documentos, requiere el permiso Documento_Leer")
    public List<Documento> findAll() {
        return documentoService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('Documento_Actualizar')")
    @Operation(summary = "Actualiza todos los documentos, requiere el permiso Documento_Actualizar")
    public Documento update(@RequestBody Documento entity) {
        return documentoService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}") 
    @PreAuthorize("hasAuthority('Documento_Actualizar_Id')")
    @Operation(summary = "Actualiza documento por id, requiere el permiso Documento_Actualizar_Id")
    public Documento partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Documento documento = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Documento.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(documento, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(documento);
    }

    // eliminar
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('Documento_Eliminar_Id')")
    @Operation(summary = "Eliminar documento por id, requiere el permiso Documento_Eliminar_Id")
    public void deleteById(@PathVariable long id) {
        documentoService.deleteById(id);
    }

}