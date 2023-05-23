package proyectoinvestigacion.proyecto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import proyectoinvestigacion.proyecto.entities.Actividad;



public interface ActividadRepository extends CrudRepository <Actividad, Long> {

    List<Actividad> findAll();
    }