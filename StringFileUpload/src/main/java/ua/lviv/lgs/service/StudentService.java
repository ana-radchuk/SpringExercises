package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.StudentRepo;
import ua.lviv.lgs.domain.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepo sRepo;
	
	public List<Student> findAllStudents() {
		return sRepo.findAllStudents();
	}
	
	public Student findOne(Integer id) {
		return sRepo.findOne(id);
	}
	
	public void save(Student student) {
		sRepo.save(student);
	}
	
	public void delete(Integer id) {
		sRepo.delete(id);
	}
}
