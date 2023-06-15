package proyecto.grupo6.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyecto.grupo6.entities.Actividad;





public interface ActividadRepository extends CrudRepository <Actividad, Long> {

    List<Actividad> findAll();
    }