package com.avatech.administrative.service;


import com.avatech.administrative.model.bo.Project;
import com.avatech.administrative.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/9/13.
 */


@Service
public class ProjectService implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;


    public List<Project> fetchProjects(){
        List<Project> projectList = projectRepository.findProjects();
        return projectList;
    }
}
