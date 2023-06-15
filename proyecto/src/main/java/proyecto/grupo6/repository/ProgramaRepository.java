package proyecto.grupo6.repository;

  import org.springframework.data.repository.CrudRepository;

import proyecto.grupo6.entities.Programa;

import java.util.List;
     
     public interface ProgramaRepository extends CrudRepository<Programa, Long> {
     
         List<Programa> findAll();
     
     
     
     }
 
