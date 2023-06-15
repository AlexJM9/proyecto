package proyecto.grupo6.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyecto.grupo6.entities.Documento;




public interface DocumentoRepository extends CrudRepository <Documento,Long>{
    List<Documento> findAll(
        
    );
    
}
