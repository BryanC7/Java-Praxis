package cl.praxis.reportes_inmobiliaria.services;

import java.util.List;

public interface IBaseCrud<T> {
    List<T> getAll();
    T getById(Long id);
    T create(T t);
    T update(T t);
    void delete(Long id);
}
