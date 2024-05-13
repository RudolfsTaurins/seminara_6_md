package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	//public absract pēc noklusējuma
	ArrayList<Grade> findByStudentIds(long id);

	ArrayList<Grade> findByGrvalueLessThan(int i);

	//vaicajums ir pa tieso būvēts datubāzes tabulai
	@Query(nativeQuery = true, value = "SELECT AVG(grvalue) FROM grade_table WHERE idc=?1")
	float calculateAVGForCourse(long id);

}
