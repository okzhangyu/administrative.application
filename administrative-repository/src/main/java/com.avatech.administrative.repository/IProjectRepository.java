package com.avatech.administrative.repository;


import com.avatech.administrative.model.bo.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by asus on 2018/9/13.
 */

public interface IProjectRepository extends CrudRepository<Project,String> {
    List<Project> findProjects();

}
