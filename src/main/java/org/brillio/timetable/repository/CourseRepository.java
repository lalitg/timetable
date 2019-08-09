package org.brillio.timetable.repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import  org.brillio.timetable.model.Course;
import org.springframework.stereotype.Repository;
@Repository
public class CourseRepository {
      public static Map<Integer, Course> allCourses = new HashMap<Integer, Course>();
      CourseRepository(){
	  }
	  public static void addCourse(int id, String name, String title, int unit, int seat, List<Integer> instructors){
		  if (allCourses.get(id)==null){
		  Course cs = new Course();
		  cs.setId(id);
		  cs.setName(name);
		  cs.setTitle(title);
		  cs.setUnit(unit);
		  cs.setTotalSeat(seat);
		  cs.setAvailableSeat(seat);
		  cs.setInstructors(instructors);
		  allCourses.put(id,cs);
		  }
	  }
	  public Map<Integer, Course> getAllCourse(){
		  return allCourses;
	  }
	  public List<Course> getAllAvailableCourse(){
			Collection<Course> courses = getAllCourse().values();
			List<Course> available = new ArrayList<Course>();
			for(Course cs : courses){
				if(cs.getAvailableSeat()>0)available.add(cs);
			}
			return available;
		}
		
	  public boolean coursesAvailable(int id){
		  if(allCourses.get(id).getAvailableSeat()>0) return true;
		  else return false;
	  }
	  public void fillCourse(int id){
		  allCourses.get(id).fillSeat();
	  }
}
