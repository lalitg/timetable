package org.brillio.timetable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.brillio.timetable.model.Course;
import org.brillio.timetable.model.Instructor;
import org.brillio.timetable.repository.CourseRepository;
import org.brillio.timetable.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InstructorServices {
	@Autowired
    InstructorRepository instrepo;
	@Autowired
	CourseRepository courserepo;
		public List<String> getAvailableInstructor(){
			List<String> available = new ArrayList<String>();
			Map<Instructor, Map<Integer, Integer>> batches = instrepo.getBatches();
			System.out.println(batches);
			for(Instructor inst : batches.keySet()){
				Map<Integer, Integer> batch = batches.get(inst);
				if(batch==null){
					available.add(""+inst.getId()+ ":" +inst.getName());
					continue;
				}
				for(Integer size: batch.values()){
					if(size<=40) available.add(""+inst.getId()+ ":" +inst.getName());
					break;
				}
			}
			return available;

		}
		public List<String> getAvailableInstructorByDay(int day){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<String> available = new ArrayList<String>();
			Map<Integer, Instructor> instructors = instrepo.getAllInstructor();
			for(Course cs : courses){
				for(Integer inst : cs.getInstructors()){
					Instructor ins = instructors.get(inst);
					if(ins.getAvailableDay(day)) available.add(ins.getName());
				}
			}
			return available;

		}
		public List<String> getAvailableInstructorByCourse(int id){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<String> available = new ArrayList<String>();
			Map<Integer, Instructor> instructors = instrepo.getAllInstructor();
			for(Course cs : courses){
				if(cs.getId()==id){
				for(Integer inst : cs.getInstructors()){
					Instructor ins = instructors.get(inst);
					//if(ins.getAvailableDay(day))
					available.add(ins.getName());
				}
				}
			}
			return available;
		}
		public List<String> getAvailableInstructorByTimeSlot(int slot){
			List<Course> courses = courserepo.getAllAvailableCourse();
			List<String> available = new ArrayList<String>();
			Map<Integer, Instructor> instructors = instrepo.getAllInstructor();
			for(Course cs : courses){
				for(Integer inst : cs.getInstructors()){
					Instructor ins = instructors.get(inst);
					if(ins.getTimeslot()==slot) available.add(ins.getName());
				}		
			}
			return available;
		}
}
