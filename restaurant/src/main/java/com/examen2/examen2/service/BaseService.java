package com.examen2.examen2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.examen2.examen2.repository.BaseRepository;

public abstract class BaseService<T> {

    @Autowired
    BaseRepository<T> baseRepository;

    public BaseService(BaseRepository<T> repository) {
        this.baseRepository = repository;
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public T save(T object) {
        return baseRepository.save(object);
    }

    public T findById(Long id) {
        return baseRepository.findById(id).orElse(null);
    }

    public T update(T object) {
        return save(object);
    }

    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }

}
