package proyecto.grupo6.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "proyecto")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String justificacion;
    private String antecedentes;

    @OneToMany(mappedBy = "idDocumento")
    private List<Programa> programaList;
    
}
