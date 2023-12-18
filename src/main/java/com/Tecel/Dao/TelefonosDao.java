package com.Tecel.Dao;
import com.Tecel.Model.Telefonos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TelefonosDao extends JpaRepository<Telefonos, Long> {
    //Si quieres agregar otro tipo de busqueds se coloca aca
    public List<Telefonos> findBymodelo (String modelo);
    public List<Telefonos> findBymarca(String marca);



}

