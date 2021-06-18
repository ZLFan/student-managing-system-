package com.llm.work.repository;

import com.llm.work.entity.SG;
import com.llm.work.entity.SGPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SGRepository extends JpaRepository<SG, SGPrimaryKey> {
    //find by teacher number
    @Query(value="select * from SG where stunum =?1",nativeQuery = true)
    List<SG> findByStunum(String stunum);
    //find by course number
    @Query(value="select * from SG where groupnum =?1",nativeQuery = true)
    List<SG> findByGroupnum(String groupnum);
    //delete by teacher number
    @Query(value="delete  from SG where stunum =?1",nativeQuery = true)
    List<SG> deleteByStunum(String stunum);
    //delete by course number
    @Query(value="delete  from SG where groupnum =?1",nativeQuery = true)
    List<SG> deleteByGroupnum(String groupnum);
}
