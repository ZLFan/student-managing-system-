package com.llm.work.repository;

import com.llm.work.entity.Login;
import com.llm.work.entity.SC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<com.llm.work.entity.Login, String> {
    @Query(value="select * from login where username =?1",nativeQuery = true)
    Login getLogFlag(String username);
}
