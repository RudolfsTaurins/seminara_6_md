package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

	//pēc noklusējuma ir public abstract 
	ArrayList<Course> findByGradesStudentIds(long id);

	ArrayList<Course> findByProfessorIdp(long id);
	
	ArrayList<Course> findByCp(int cp);

}
