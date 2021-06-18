package com.llm.work.repository;

import com.llm.work.entity.SC;
import com.llm.work.entity.SCPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SCRepository extends JpaRepository<SC, SCPrimaryKey> {
    //find by teacher number
    @Query(value="select * from SC where stunum =?1",nativeQuery = true)
    List<SC> findByStunum(String stunum);
    //find by course number
    @Query(value="select * from SC where cornum =?1",nativeQuery = true)
    List<SC> findByCornum(String cornum);
    //delete by teacher number
    @Query(value="delete  from SC where stunum =?1",nativeQuery = true)
    List<SC> deleteByStunum(String stunum);
    //delete by course number
    @Query(value="delete  from SC where cornum =?1",nativeQuery = true)
    List<SC> deleteByCornum(String cornum);
}
