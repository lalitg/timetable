package org.brillio.timetable.controller;

import java.util.List;

import org.brillio.timetable.model.TimeTable;
import org.brillio.timetable.service.CourseServices;
import org.brillio.timetable.service.InstructorServices;
import org.brillio.timetable.service.TimeTableServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class TimeTableController {
	
	@Autowired
	CourseServices courseservice; 
	
	@Autowired
	InstructorServices instructorservice;
	
	@Autowired
	TimeTableServices timetableservice;
	
	@GetMapping(value = "/get_courses", produces = "application/json")
	public List<Integer> getAvailableCourse() {
		return courseservice.getAvailableCourse();
	}
	@GetMapping(value = "/get_available_courses_by_day/{day}", produces = "application/json")
	public List<Integer> getAvailableCourseByDay(@PathVariable(value="day") String day) {
		 return courseservice.getAvailableCourseByDay(Integer.parseInt(day));
	}
	@GetMapping(value = "/get_available_courses_by_inst_id/{inst_id}", produces = "application/json")
	public List<Integer> getAvailableCourseById(@PathVariable(value="inst_id") String inst_id) {
		return courseservice.getAvailableCourseByInstructorId(Integer.parseInt(inst_id));

	}
	@GetMapping(value = "/get_available_courses_by_timeslot/{time_slot}", produces = "application/json")
	public List<Integer> getAvailableCourseByTimeSlot(@PathVariable(value="time_slot") String time_slot) {

		return courseservice.getAvailableCourseByTimeSlot(Integer.parseInt(time_slot));

	}
	@GetMapping(value = "/get_Instructor", produces = "application/json")
	public List<String> getAvailableInstructor() {
		return instructorservice.getAvailableInstructor();
	}

	@GetMapping(value = "/get_available_instructor_by_day/{day}", produces = "application/json")
	public List<String> getAvailableInstructorByDay(@PathVariable(value="day") String day) {
		return instructorservice.getAvailableInstructorByDay(Integer.parseInt(day));
	}

	@GetMapping(value = "/get_available_instructor_by_course/{course}", produces = "application/json")
	public List<String> getAvailableInstructorByCourse(@PathVariable(value="course") String course) {
		return instructorservice.getAvailableInstructorByCourse(Integer.parseInt(course));
	}
	@GetMapping(value = "/get_available_instructor_by_timeslot/{time_slot}", produces = "application/json")
	public List<String> getAvailableInstructorByTimeSlot(@PathVariable(value="time_slot") String time_slot) {
		return instructorservice.getAvailableInstructorByTimeSlot(Integer.parseInt(time_slot));
	}
	
	@GetMapping(value = "/save_timetable/{candidate_id}/{course}/{instrcutor_id}/{day}", produces = "application/json")
	public boolean saveTimeTable(@PathVariable(value="candidate_id") String candidate_id,
				@PathVariable(value="course") String course,
			@PathVariable(value="instrcutor_id") String instrcutor_id,
			@PathVariable(value="day") String day) {
		   return timetableservice.saveTimeTable(Integer.parseInt(candidate_id), Integer.parseInt(course), Integer.parseInt(instrcutor_id), Integer.parseInt(day));
	}
	@GetMapping(value = "/add_timetable/{candidate_id}/{course}/{instrcutor_id}/{day}", produces = "application/json")
	public List<TimeTable> addTimeTable(@PathVariable(value="candidate_id") String candidate_id,
			@PathVariable(value="course") String course,
			@PathVariable(value="instrcutor_id") String instrcutor_id,
			@PathVariable(value="day") String day) {
		return timetableservice.addTimeTable(Integer.parseInt(candidate_id), Integer.parseInt(course), Integer.parseInt(instrcutor_id), Integer.parseInt(day));
	}
	
   @GetMapping(value = "/delete_timetable/{candidate_id}/{course}/{instrcutor_id}/{day}", produces = "application/json")
	public boolean deleteTimeTable(@PathVariable(value="candidate_id") String candidate_id,
			@PathVariable(value="course") String course,
			@PathVariable(value="instrcutor_id") String instrcutor_id,
			@PathVariable(value="day") String day) {
		return timetableservice.deleteTimeTable(Integer.parseInt(candidate_id), Integer.parseInt(course), Integer.parseInt(instrcutor_id), Integer.parseInt(day));
	}
}
