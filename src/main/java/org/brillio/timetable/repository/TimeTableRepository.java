package org.brillio.timetable.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.brillio.timetable.model.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class TimeTableRepository {
	 @Autowired
	CourseRepository courserepo;
	@Autowired
	InstructorRepository instrepo;
      public static Map<Integer, List<TimeTable>> timetables = new HashMap<Integer, List<TimeTable>>();
	  private static Set<String> registeredTT = new HashSet<String>();
      TimeTableRepository(){
	  }
	  public boolean saveTimeTable(int id, int courseId, int instructorId, int day){
		  try{
		  if (registeredTT.contains(id+""+courseId+""+instructorId+""+day)) return false;
		  TimeTable tt = new TimeTable();
		  tt.setCourseId(courseId);
		  tt.setInstructorId(instructorId);
		  tt.setDay(day);
		  if (timetables.get(id)==null) timetables.put(id, new ArrayList<TimeTable>());
		  timetables.get(id).add(tt);
		  registeredTT.add(id+""+courseId+""+instructorId+""+day);
		  courserepo.fillCourse(courseId);
		  instrepo.fillBatch(instructorId, day);		  
		  } catch (Exception e){
			  return false;
		  }
		  return true;
		  }
	  public Map<Integer, List<TimeTable>> getAllTimeTable(){
		  return timetables;
	  }
	  	  public List<TimeTable> addTimeTable(int id, int courseId, int instructorId, int day){
		  if (registeredTT.contains(id+""+courseId+""+instructorId+""+day)) return new ArrayList<>();
		  if (!instrepo.batchAvailable(instructorId, day)) return new ArrayList<>();
		  if (!courserepo.coursesAvailable(courseId)) return new ArrayList<>();
		  TimeTable tt = new TimeTable();
		  tt.setCourseId(courseId);
		  tt.setInstructorId(instructorId);
		  tt.setDay(day);
		  List<TimeTable> temp = null;
		  if (timetables.get(id)==null) {
			  temp = new ArrayList<TimeTable>();

		  }else{
			  temp = new ArrayList<TimeTable>(timetables.get(id));
		  }
          temp.add(tt);
		  return temp;

		  
		  }
		  public boolean deleteTimeTable(int id, int courseId, int instructorId, int day){
			  try{
		  List<TimeTable> tt = timetables.get(id);
		  TimeTable found = null;
		  for(TimeTable t: tt){
			  if((t.getCourseId()==courseId)&& t.getInstructorId()==instructorId && t.getDay() == day){
				  found = t;
				  break;
			  }
		  }
		  if(found==null)return false;
		  tt.remove(found);
		  }
		  catch (Exception e){
			  return false;
		  }return true;
		  }
}
