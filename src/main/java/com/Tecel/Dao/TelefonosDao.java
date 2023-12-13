package com.Tecel.Dao;
import com.Tecel.Model.Telefonos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonosDao extends JpaRepository<Telefonos, Long> {
    //Si quieres agregar otro tipo de busqueds se coloca aca
}
