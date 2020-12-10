package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UniversityRepository;
import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService{
	
	@Autowired
	private UniversityRepository uniRepository;

	@Override
	public University save(University university) {
		return uniRepository.saveAndFlush(university);
	}

	@Override
	public University findById(Integer id) {
		return uniRepository.getOne(id);
	}

	@Override
	public University update(University university) {
		return uniRepository.save(university);
	}

	@Override
	public void deleteById(Integer id) {
		uniRepository.deleteById(id);
		
	}

	@Override
	public List<University> findAll() {
		return uniRepository.findAll();
	}

	@Override
	public List<University> findByTitle(String title) {
		return uniRepository.findByTitle(title);
	}
	

}
