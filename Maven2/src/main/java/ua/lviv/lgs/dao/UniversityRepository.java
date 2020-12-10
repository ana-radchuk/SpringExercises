package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.University;

public interface UniversityRepository extends JpaRepository<University, Integer>, CrudRepository<University, Integer> {
	
	List<University> findByTitle(String title);

}
