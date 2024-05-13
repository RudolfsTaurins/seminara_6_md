package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IGradeFilterService {

	public abstract ArrayList<Grade> 
		selectGradesByStudentId(long id) throws Exception;
	
	public abstract ArrayList<Grade> selectFailedGrades() throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(long id) throws Exception; 
	
}
