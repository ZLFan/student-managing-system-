package com.llm.work.repository;

        import com.llm.work.entity.SG;
        import com.llm.work.entity.Teacher;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;
        import org.springframework.web.bind.annotation.GetMapping;

        import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {

}
