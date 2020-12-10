package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student, Integer> {

	List<Student> findByName(String name);
	
}
