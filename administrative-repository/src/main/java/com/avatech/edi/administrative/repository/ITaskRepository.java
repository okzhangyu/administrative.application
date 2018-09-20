package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.TaskRecord;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<TaskRecord,Integer> {


}
