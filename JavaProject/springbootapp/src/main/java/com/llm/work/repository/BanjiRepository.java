package com.llm.work.repository;

import com.llm.work.entity.Banji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface BanjiRepository extends JpaRepository<Banji,String> {

    @Query(value="select * from banji where teanum =?1",nativeQuery = true)
    Banji findByTeanum(String teanum);
}
