package org.brillio.timetable.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.brillio.timetable.model.Course;
import org.brillio.timetable.model.Instructor;
import org.brillio.timetable.repository.CourseRepository;
import org.brillio.timetable.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CourseServices {
	@Autowired
	CourseRepository courserepo;
	@Autowired
	InstructorRepository instrepo;
		public List<Integer> getAvailableCourse(){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<Integer> available = new ArrayList<Integer>();
			for(Course cs : courses){
				available.add(cs.getId());
			}
			return available;
		}
		public List<Integer> getAvailableCourseByDay(int day){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<Integer> available = new ArrayList<Integer>();
			Map<Integer, Instructor> instructors = instrepo.getAllInstructor();
			for(Course cs : courses){
				for(Integer inst : cs.getInstructors()){
					Instructor ins = instructors.get(inst);
					if(ins.getAvailableDay(day)) available.add(cs.getId());
				}
			}
			return available;
		}
		public List<Integer> getAvailableCourseByInstructorId(int id){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<Integer> available = new ArrayList<Integer>();
			for(Course cs : courses){
				if(cs.getInstructors().contains(id))available.add(cs.getId());
			}
			return available;
		}
		public List<Integer> getAvailableCourseByTimeSlot(int slot){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<Integer> available = new ArrayList<Integer>();
			Map<Integer, Instructor> instructors = instrepo.getAllInstructor();
			for(Course cs : courses){
				for(Integer inst : cs.getInstructors()){
					Instructor ins = instructors.get(inst);
					if(ins.getTimeslot()==slot) available.add(cs.getId());
				}		
			}
			return available;
		}		
}
