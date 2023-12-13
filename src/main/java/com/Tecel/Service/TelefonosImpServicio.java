package com.Tecel.Service;

import com.Tecel.Dao.TelefonosDao;
import com.Tecel.Model.Telefonos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TelefonosImpServicio implements TelefonosService {
    //Inyectamos ls metodos del dao, el cual a su vez hereda de JPARepository
    @Autowired
    TelefonosDao telefonosDao;


    @Override
    public void guardar(Telefonos telefono) {
        telefonosDao.save(telefono);
    }

    @Override
    public void editar(Telefonos telefono) {
        telefonosDao.save(telefono);

    }

    @Override
    public void eliminar(Long id) {
        Telefonos TelAux = new Telefonos(id);
        telefonosDao.delete(TelAux);
    }

    @Override
    public Telefonos buscar(Long id) {
        return telefonosDao.findById(id).orElse(null);
    }

    @Override
    public List<Telefonos> listar() {
        return telefonosDao.findAll();
    }
}
