package proyectoinvestigacion.proyecto.entities;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    
    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "programa")
    public class Programa {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String titulo;
        private String carrera;
    
    
    }