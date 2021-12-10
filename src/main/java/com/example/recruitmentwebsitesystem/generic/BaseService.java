package com.example.recruitmentwebsitesystem.generic;

import java.util.List;

import com.example.recruitmentwebsitesystem.entity.Jobs;
import org.springframework.data.domain.Page;

public interface BaseService<T,ID> {
    List<T> findAll();

    Page<T> findPage( int page, int size);

    T findById(ID id);

    T create(T obj);

    T update(T obj);

    void delete(ID key);

//    boolean existsById(ID key);

    Long count();

//    public List<Jobs> getListNewJobs(Integer numberDate, Integer page,Integer size);
//    public List<Jobs> getListJobSalary(Integer numberDate, Integer page,Integer size);
//    public List<Jobs> getListJobDeadline(Integer numberDate, Integer page,Integer size);
//    public List<Jobs> getAllJobs();
//    public Jobs getJob(int id);
//    public List<Jobs> getTimeJobs();
//    public  List<Jobs> getSalaryJobs();
}
