package com.avatech.edi.administrative.repository;


import com.avatech.edi.administrative.model.bo.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by asus on 2018/9/13.
 */

public interface IProjectRepository extends CrudRepository<Project,String> {
    List<Project> findProjects();

}
