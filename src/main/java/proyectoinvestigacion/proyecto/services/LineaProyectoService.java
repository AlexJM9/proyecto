package proyectoinvestigacion.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectoinvestigacion.proyecto.entities.LineaProyecto;
import proyectoinvestigacion.proyecto.repository.LineaProyectoRepository;

import java.util.List;

@Service
public class LineaProyectoService {
    //atributo delimitador de acceso,tipo de dato,nombre del atributo
    @Autowired
    private LineaProyectoRepository lineaProyectoRepository;

    //Crud
    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    public LineaProyecto save( LineaProyecto entity){
        return lineaProyectoRepository.save(entity);
    }

    //read
    public LineaProyecto findById(long id){
        return lineaProyectoRepository.findById(id).orElse(null);
    }
    //put

    //delete
    public void delete(LineaProyecto entity){
        lineaProyectoRepository.delete(entity);
    }
    //traer todo

    public List findAll(){
        return (List) lineaProyectoRepository.findAll();
    }


}