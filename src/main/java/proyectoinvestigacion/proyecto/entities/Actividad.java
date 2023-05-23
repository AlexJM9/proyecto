package proyectoinvestigacion.proyecto.entities;

import java.time.LocalDate;

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
    @Table(name = "actividad")
    public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Nombre;
    private LocalDate Fecha_inicio;
    private LocalDate Fecha_final;
    }