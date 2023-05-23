package proyectoinvestigacion.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import proyectoinvestigacion.proyecto.entities.LineaProyecto;

import java.util.List;

public interface LineaProyectoRepository extends CrudRepository<LineaProyecto, Long> {

    List<LineaProyecto> findAll();



}
