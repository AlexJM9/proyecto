package proyecto.grupo6.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.grupo6.entities.Documento;
import proyecto.grupo6.repository.DocumentoRepository;



@Service
public class DocumentoService {
    //atributo delimitador de acceso,tipo de dato,nombre del atributo
    @Autowired
    private DocumentoRepository  documentoRepository;

    //Crud
    //crear
    //metod delimitador de acceso,tipo de dato que retorna,nombre del metodo/funcion
    public Documento save( Documento entity){
        return documentoRepository.save(entity);
    }

    //read
    public Documento findById(long id){
        return documentoRepository.findById(id).orElse(null);
    }

    //delete
    public void deleteById(long id){
        documentoRepository.deleteById(id);
    }

    //traer todo
   public List<Documento> findAll(){
       return documentoRepository.findAll();
   }
}