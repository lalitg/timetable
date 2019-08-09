package org.brillio.timetable.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.brillio.timetable.model.Course;
import org.brillio.timetable.model.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepository {
	public static Map<Integer, Instructor> allInstructor = new HashMap<Integer, Instructor>();
	

	InstructorRepository(){
		
	  }
	  public  static void addInstructor(int id, String name, int courseId, int slot, List<Integer> days){
		  if (allInstructor.get(id)==null){
		  Instructor is = new Instructor();
		  is.setId(id);
		  is.setName(name);
		  is.setCourseId(courseId);
		  is.setTimeslot(slot);
		  is.setDay(days);
		  allInstructor.put(id, is);
		  }
	  }
	  public Map<Integer, Instructor> getAllInstructor(){
		  return allInstructor;
	  }
	  public Map<Instructor, Map<Integer, Integer>> getBatches(){
		  Map<Instructor, Map<Integer, Integer>> batches = new HashMap<Instructor, Map<Integer, Integer>>();
		  for(Integer inst : allInstructor.keySet()){
			  Instructor is = allInstructor.get(inst);
			  batches.put(is, is.getBatch());
		  }
		  return batches;
	  }
	  public boolean batchAvailable(int id, int day){
		  Instructor inst = allInstructor.get(id);
		  return inst.getAvailableDay(day);
	  }
	  public void fillBatch(int id, int day){
		  Instructor inst = allInstructor.get(id);
		  inst.addStudent(day);
      }
}
