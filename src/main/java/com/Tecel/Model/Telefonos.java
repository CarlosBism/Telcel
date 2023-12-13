package com.Tecel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;


@Entity
@Table(name = "Telefonos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Telefonos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Marca;
    private String Modelo;
    private String Color;
    private String Almacenamiento;
    private String Ram;
    private Double precio;


    public Telefonos (Long id){
        this.id = id;
    }
}


