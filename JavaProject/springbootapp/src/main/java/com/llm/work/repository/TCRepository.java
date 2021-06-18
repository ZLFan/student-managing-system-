package com.llm.work.repository;

import com.llm.work.entity.TC;
import com.llm.work.entity.TCPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TCRepository extends JpaRepository<TC, TCPrimaryKey> {
    //find by teacher number
    @Query(value="select * from TC where teanum =?1",nativeQuery = true)
    List<TC> findByTeanum(String teanum);
    //find by course number
    @Query(value="select * from TC where cornum =?1",nativeQuery = true)
    List<TC> findByCornum(String cornum);
    //delete by teacher number
    @Query(value="delete  from TC where teanum =?1",nativeQuery = true)
    List<TC> deleteByTeanum(String teanum);
    //delete by course number
    @Query(value="delete  from TC where cornum =?1",nativeQuery = true)
    List<TC> deleteByCornum(String cornum);
}
