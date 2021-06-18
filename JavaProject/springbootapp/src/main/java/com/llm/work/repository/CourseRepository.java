package com.llm.work.repository;

import com.llm.work.entity.Course;
import com.llm.work.entity.SC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<com.llm.work.entity.Course,String> {

    @Query(value="select * from course where teanum =?1",nativeQuery = true)
    List<Course> findByTeanum(String teanum);
}
