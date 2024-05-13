package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService {

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
	
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studentRepo.existsById(id)) 
			throw new Exception("There is no student with this id (" + id + ")");
		
		
		ArrayList<Course> result = 
				courseRepo.findByGradesStudentIds(id);
		
		if(result.isEmpty()) 
			throw new Exception("There is no course linked to this student");
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!profRepo.existsById(id)) 
			throw new Exception("There is no professor with this id (" + id + ")");
		
			
		ArrayList<Course> result = 
				courseRepo.findByProfessorIdp(id);
		
		if(result.isEmpty())
			throw new Exception("There is no course linked to this professor");

		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
		if(cp < 0 || cp > 20) throw new Exception("Cp should be positive and less than 21");
		
		ArrayList<Course> result = 
				courseRepo.findByCp(cp);
		
		if(result.isEmpty()) 
			throw new Exception("There is no course with this CP");
		
		return result;
	}

}
