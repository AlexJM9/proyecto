package proyectoinvestigacion.proyecto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyectoinvestigacion.proyecto.entities.Documento;


public interface DocumentoRepository extends CrudRepository <Documento,Long>{
    List<Documento> findAll(
        
    );
    
}
