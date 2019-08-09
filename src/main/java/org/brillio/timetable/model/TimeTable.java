package org.brillio.timetable.model;

public class TimeTable {

		public int getCourseId() {
			return courseId;
		}
		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}
		public int getInstructorId() {
			return instructorId;
		}
		public void setInstructorId(int instructorId) {
			this.instructorId = instructorId;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		int courseId;
		int instructorId;
		int day;
		
	}

