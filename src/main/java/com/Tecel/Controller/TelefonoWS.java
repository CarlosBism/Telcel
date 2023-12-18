package com.Tecel.Controller;

import com.Tecel.Model.Telefonos;
import com.Tecel.Service.TelefonosImpServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

//EndPoints que se consumiran desde el Fornt -Angular-
@RestController
@RequestMapping("Telefonos")
public class TelefonoWS {

//    Inyectamos la implementaciondel servicio de TELFONO
    @Autowired
    TelefonosImpServicio telefonosImpServicio;

//    http://Localhost:8080/Telefonos/listar
    @GetMapping("listar")
    public ResponseEntity<?>listar(){



        List<Telefonos> telefonosList =  telefonosImpServicio.listar();
        if(telefonosList.isEmpty()){
            return new ResponseEntity<>("Aun no se agregan Telefonos a la lista",HttpStatus.OK);
        }else{

            return new ResponseEntity<>("Lista de Telefonos : \n"+telefonosList,HttpStatus.OK);
        }
    }

//    http://Localhost:8080/Telefonos/Guardar
    @PostMapping("Guardar")
    public ResponseEntity<?> guardar(@RequestBody Telefonos telefono){
        try{
            telefonosImpServicio.guardar(telefono);
            return new ResponseEntity<>("Se Guardo con exito",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al guardar"+e.getMessage(),HttpStatus.OK);
        }
    }

//    http://Localhost:8080/Telefonos/Editar
    @PostMapping("Editar")
    public ResponseEntity<?> editar(@RequestBody Telefonos telefonos){

        try{
            telefonosImpServicio.editar(telefonos);
            return new ResponseEntity<>("Se edito con exito.",HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>("Error al editar"+e.getMessage(),HttpStatus.NOT_MODIFIED);
        }


    }

//    http://Localhost:8080/Telefonos/Eliminar?id=11
    @PostMapping("Eliminar")
    public ResponseEntity<String> eliminar(@RequestParam Long id){
        String alert = "";
        Telefonos taux = telefonosImpServicio.buscar(id);

        if (taux == null){
            alert = "El Telefono No existe";
            return new ResponseEntity<>(alert, HttpStatus.CREATED);
        }

        alert = taux.getMarca()+" "+taux.getModelo()+" Se elimino con Exito";
        try {
            telefonosImpServicio.eliminar(id);
            return new ResponseEntity<>(alert, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("No se Elimino",HttpStatus.CREATED);
        }


    }

//    http://Localhost:8080/Telefonos/Buscar
    @GetMapping("Buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Telefonos tAux = telefonosImpServicio.buscar(id);
        if(tAux != null){
            return new  ResponseEntity<>(telefonosImpServicio.buscar(id),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No se encontro el telefono con el id: "+id,HttpStatus.NOT_FOUND);
        }

    }

//    http://Localhost:8080/Telefonos/buscarModelo/Xiaomi
    @GetMapping("/buscarModelo/{modelo}")
    public ResponseEntity<?> findByModelo(@PathVariable String modelo) {
        List<Telefonos> telefonosList = telefonosImpServicio.findByModelo(modelo);
        if(telefonosList.isEmpty()){
            return new ResponseEntity<>("No se encontro un Telefono con modelo: "+modelo,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(telefonosList,HttpStatus.OK);
        }

    }

    @GetMapping("buscarMarca/{marca}")
    public ResponseEntity<?> findByMarca(@PathVariable String marca){
        List<Telefonos> telefonosList = telefonosImpServicio.findByMarca(marca);
        if(telefonosList.isEmpty()){
            return new ResponseEntity<>("No se encontraron resultados",HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(telefonosList,HttpStatus.OK);
        }
    }



}
