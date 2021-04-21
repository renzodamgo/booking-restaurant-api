package com.booking.repositories;

import com.booking.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //?1 representa al primer argumento *email*
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);


    @Query("SELECT s FROM Student s WHERE s.firstName=?1 AND s.age>=?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEquals(String name,Integer age);

    @Query(
            value = "SELECT * FROM students WHERE first_name =:firstName AND age>=:age",
            nativeQuery = true
    )
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualsNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age
    );
}
