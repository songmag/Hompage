package com.songmag.tiny.service.userService.dto;

import java.util.List;

public interface Repsitory<T extends ImplRepository,D extends DataObject>{

    T get();
    T get(D object);

    List<T> findAll(D object);
    List<T> findAllWithLimit(D object, long offset, long limit);

    long insert(List<D> objects);
    long update(List<D> objects);
}
