package com.examen2.examen2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examen2.examen2.models.Mesa;
import com.examen2.examen2.repository.MesaRepository;

@Service
public class MesaService extends BaseService<Mesa> {

    @Autowired
    MesaRepository mesaRepository;

    public MesaService(MesaRepository repository) {
        super(repository);
    }

    public Mesa updateMesa(Long id, Mesa updateMesa) {
        Optional<Mesa> optionalMesa = mesaRepository.findById(id);
        if (optionalMesa.isPresent()) {
            Mesa Mesa = optionalMesa.get();
            Mesa.setGuest(updateMesa.getGuest());
            Mesa.setNumber(updateMesa.getNumber());
            Mesa.setNotes(updateMesa.getNotes());
            return mesaRepository.save(Mesa);
        }
        return null;
    }

    public List<Mesa> findOpenTables() {
        return mesaRepository.findByUserIsNull();
    }
}
