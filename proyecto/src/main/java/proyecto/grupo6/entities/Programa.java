package proyecto.grupo6.entities;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    
        @JoinColumn(name = "id_actividad", referencedColumnName = "id")
        @ManyToOne 
        private Actividad idActividad;

            @JoinColumn(name = "id_lineaproyecto", referencedColumnName = "id")
            @ManyToOne 
            private LineaProyecto idLineaProyecto;

            @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
            @ManyToOne 
            private Documento idDocumento;


    }
