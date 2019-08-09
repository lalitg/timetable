package org.brillio.timetable.service;

import org.brillio.timetable.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.brillio.timetable.model.TimeTable;

@Service
public class TimeTableServices {
	@Autowired
	TimeTableRepository ttrepo;
	public List<TimeTable> addTimeTable(int studentId, int courseId, int instructorId, int day){
				return ttrepo.addTimeTable(studentId, courseId, instructorId, day);
	}
	public boolean deleteTimeTable(int studentId, int courseId, int instructorId, int day){
				return ttrepo.deleteTimeTable(studentId, courseId, instructorId, day);
	}
	public boolean saveTimeTable(int studentId, int courseId, int instructorId, int day){
			return 	ttrepo.saveTimeTable(studentId, courseId, instructorId, day);
	}
}
