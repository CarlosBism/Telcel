package com.Tecel.Service;
import com.Tecel.Model.Telefonos;
import java.util.List;

//Definicion de metodos a impementar
public interface TelefonosService {
    public void guardar(Telefonos telefono);

    public void editar(Telefonos telefono);

    public void eliminar(Long id);

    public Telefonos buscar(Long id);

    public List<Telefonos> listar();
    public List<Telefonos> findByModelo(String modelo);
    public List<Telefonos> findByMarca(String marca);



}
