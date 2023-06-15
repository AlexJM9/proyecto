package proyecto.grupo6.repository;

import org.springframework.data.repository.CrudRepository;

import proyecto.grupo6.entities.LineaProyecto;

import java.util.List;

public interface LineaProyectoRepository extends CrudRepository<LineaProyecto, Long> {

    List<LineaProyecto> findAll();



}
