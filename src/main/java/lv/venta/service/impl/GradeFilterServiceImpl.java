package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradeFilterService;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService{

	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!studentRepo.existsById(id)) 
			throw new Exception("There is no student with this id (" + id + ")");
		
		ArrayList<Grade> result = 
				gradeRepo.findByStudentIds(id);
		
		if(result.isEmpty()) 
			throw new Exception("There is no grade linked to this student");
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		if(gradeRepo.count()==0) throw new Exception("There is no grade in the system");

		ArrayList<Grade> result = 
				gradeRepo.findByGrvalueLessThan(4);
		
		if(result.isEmpty())
			throw new Exception("There is no failed grade");
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		
		if(!courseRepo.existsById(id))
			throw new Exception("There is no course with this id (" + id + ")");
		
		float result = gradeRepo.calculateAVGForCourse(id);
		
		//TODO pārbaudīt, vai vispār ir tajā kursā kaut viena atzīme
		return result;
	}

}
