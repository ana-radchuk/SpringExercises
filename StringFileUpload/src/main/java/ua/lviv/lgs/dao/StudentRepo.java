package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Student;

@Repository
public class StudentRepo {
	private List<Student> students = new ArrayList<>();
	
	public void init() {
		Student s1 = new Student();
		s1.setId(1);
		s1.setFirstName("Ivan");
		s1.setLastName("Ivanenko");
		s1.setAge(23);
		
		students.add(s1);	
	}
	
	public List<Student> findAllStudents() {
		return students;
	}
	
	public Student findOne(Integer id) {
		return students.stream()
				.filter(student -> student.getId() == id)
				.findFirst().orElse(null);
	}

	public void save(Student student) {
		Student sToUpdate = null;
		
		if(student.getId() != null) {
			sToUpdate = findOne(student.getId());
			int studentIndex = students.indexOf(sToUpdate);
			sToUpdate.setFirstName(student.getFirstName());
			sToUpdate.setLastName(student.getLastName());
			sToUpdate.setAge(student.getAge());
			students.set(studentIndex, sToUpdate);
		} else {
			// save
			student.setId(students.size()+1);
			students.add(student);
		}
	}
	
	public void delete(Integer id) {
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()) {
			if(iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
}
