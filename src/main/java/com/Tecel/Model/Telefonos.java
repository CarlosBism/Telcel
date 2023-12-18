package com.Tecel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Mapeo de la BD usando Hibernate
@Entity
@Table(name = "Telefonos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Telefonos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marca;
    private String modelo;
    private String color;
    private String almacenamiento;
    private String ram;
    private Double precio;

    //Constructor Vacio
    public Telefonos (Long id){
        this.id = id;
    }
}


