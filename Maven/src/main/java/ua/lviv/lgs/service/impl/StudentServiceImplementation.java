package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.StudentRepository;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Override
	public Student findById(Integer id) {
		return studentRepository.getOne(id);
	}

	@Override
	public Student update(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(Integer id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

}
