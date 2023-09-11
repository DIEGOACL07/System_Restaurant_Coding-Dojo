package com.examen2.examen2.repository;
import java.util.List;
import com.examen2.examen2.models.Mesa;

public interface MesaRepository extends BaseRepository<Mesa> {
    List<Mesa> findByUserIsNull();
}
