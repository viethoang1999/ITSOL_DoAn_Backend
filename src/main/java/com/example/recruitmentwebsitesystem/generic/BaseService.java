package com.example.recruitmentwebsitesystem.generic;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

public interface BaseService<T,ID> {
    List<T> findAll();

    Page<T> findPage( int page, int size);

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    void delete(ID key);

    Long count();
}
