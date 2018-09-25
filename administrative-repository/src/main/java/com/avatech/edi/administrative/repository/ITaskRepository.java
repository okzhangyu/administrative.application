package com.avatech.edi.administrative.repository;

import com.avatech.edi.administrative.model.bo.TaskRecord;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITaskRepository extends CrudRepository<TaskRecord,Integer> {

    List<TaskRecord> findByObjectCodeAndIsSync(String objectCode, String isSync);

    List<TaskRecord> findByObjectCodeAndIsSyncAndOpType(String objectCode, String isSync,String opType);

    @Modifying
    @Query("update AVA_OA_TASK t set t.IsSync = :isSync,t.SyncMsg = :message where sc.DocEntry in :ids")
    @Transactional
    void updateTask(@Param(value = "ids") List<Integer> ids, @Param(value = "isSync")String isSync, @Param(value = "message")String message);

}
