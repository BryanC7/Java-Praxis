package cl.praxis.restaurante.services;

import java.util.List;

public interface IBaseCrud<T> {
    List<T> getAll();
    T getById(int id);
    T create(T t);
    T update(T t);
    void delete(int id);
}