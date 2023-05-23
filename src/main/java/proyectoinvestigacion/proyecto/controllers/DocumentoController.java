package proyectoinvestigacion.proyecto.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

import proyectoinvestigacion.proyecto.entities.Documento;
import proyectoinvestigacion.proyecto.services.DocumentoService;


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
    public Documento save(@RequestBody Documento entity) {
        return documentoService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    public Documento findById(@PathVariable long id) {
        return documentoService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    public List<Documento> findAll() {
        return documentoService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    public Documento update(@RequestBody Documento entity) {
        return documentoService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
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
    public void deleteById(@PathVariable long id) {
        documentoService.deleteById(id);
    }

}