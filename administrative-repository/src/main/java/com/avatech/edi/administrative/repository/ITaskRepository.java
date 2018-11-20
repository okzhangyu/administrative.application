package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.TaskRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITaskRepository extends CrudRepository<TaskRecord,Integer> {

    List<TaskRecord> findByObjectCodeAndIsSync(String objectCode, String isSync);

    List<TaskRecord> findByObjectCodeAndIsSyncAndOpType(String objectCode, String isSync,String opType);

    List<TaskRecord> findTop30ByObjectCodeAndIsSyncAndOpType(String objectCode, String isSync,String opType);
}
