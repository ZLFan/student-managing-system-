package repository;
import entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //void delete(Integer stuid);
}
