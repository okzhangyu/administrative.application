package com.avatech.administrative.service;


import com.avatech.administrative.model.bo.Project;

import java.util.List;

/**
 * Created by asus on 2018/9/13.
 */
public interface IProjectService {
      List<Project> fetchProjects();
}
