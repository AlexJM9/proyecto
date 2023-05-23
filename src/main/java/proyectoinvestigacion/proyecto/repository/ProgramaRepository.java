package proyectoinvestigacion.proyecto.repository;

  import org.springframework.data.repository.CrudRepository;

import proyectoinvestigacion.proyecto.entities.Programa;

import java.util.List;
     
     public interface ProgramaRepository extends CrudRepository<Programa, Long> {
     
         List<Programa> findAll();
     
     
     
     }
 
