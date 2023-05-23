package proyectoinvestigacion.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectoinvestigacion.proyecto.entities.Programa;
import proyectoinvestigacion.proyecto.repository.ProgramaRepository;

import java.util.List;

@Service
public class ProgramaService {
    //atributo delimitador de acceso,tipo de dato,nombre del atributo
    @Autowired
    private ProgramaRepository programaRepository;

    //Crud
    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    public Programa save( Programa entity){
        return programaRepository.save(entity);
    }

    //read
    public Programa findById(long id){
        return programaRepository.findById(id).orElse(null);
    }
    //put

    //delete
    public void delete(Programa entity){
        programaRepository.delete(entity);
    }
    //traer todo

    public List findAll(){
        return (List) programaRepository.findAll();
    }


}