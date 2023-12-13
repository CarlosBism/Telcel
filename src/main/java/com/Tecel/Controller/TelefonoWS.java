package com.Tecel.Controller;

import com.Tecel.Model.Telefonos;
import com.Tecel.Service.TelefonosImpServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Telefonos")
public class TelefonoWS {

//    Inyectamos la implementaciondel servicio de TELFONO
    @Autowired
    TelefonosImpServicio telefonosImpServicio;

//    http://Localhost:8080/Telefonos/listar
    @GetMapping("listar")
    public List<Telefonos>listar(){
        return telefonosImpServicio.listar();
    }

//    http://Localhost:8080/Telefonos/Guardar
    @PostMapping("Guardar")
    public void guardar(@RequestBody Telefonos telefono){
        telefonosImpServicio.guardar(telefono);
    }

//    http://Localhost:8080/Telefonos/Editar
    @PostMapping("Editar")
    public void editar(@RequestBody Telefonos telefonos){
        telefonosImpServicio.editar(telefonos);

    }

//    http://Localhost:8080/Telefonos/Eliminar?id=11
    @PostMapping("Eliminar")
    public void eliminar(@RequestParam Long id){
        telefonosImpServicio.eliminar(id);
    }

//    http://Localhost:8080/Telefonos/Buscar
    @GetMapping("Buscar/{id}")
    public Telefonos buscar(@PathVariable Long id){
        return telefonosImpServicio.buscar(id);
    }

}
