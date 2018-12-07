package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.bo.Department;
import com.avatech.edi.administrative.model.bo.MasterData;
import com.avatech.edi.administrative.model.bo.TaskRecord;
import com.avatech.edi.administrative.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    public List<Department> fetchDepartments(List<TaskRecord> taskRecords){
        if(taskRecords == null || taskRecords.size() == 0)
            return null;
        List<Department> departments = new ArrayList<>();
        Department department;
        for (TaskRecord task:taskRecords) {
            department = departmentRepository.findByCode(MasterData.getUniqueKey(task.getCompanyName(), task.getUniqueKey()));
            if(department != null)
                departments.add(department);
        }
        return departments;
    }

    public Department fetchDepartment(TaskRecord record){
        return departmentRepository.findByCode(MasterData.getUniqueKey(record.getCompanyName(), record.getUniqueKey()));

    }
}
