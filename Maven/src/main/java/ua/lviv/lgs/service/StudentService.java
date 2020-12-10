package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.domain.Student;

public interface StudentService {
	
	Student save(Student student);
	Student findById(Integer id);
	Student update(Student student);
	void deleteById(Integer id);
	List<Student> findAll();
	List<Student> findByName(String name);
	
}
