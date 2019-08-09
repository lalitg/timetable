package org.brillio.timetable.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Instructor {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public List<Integer> getDay() {
		return day;
	}
	public void setDay(List<Integer> day) {
		this.day = day;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}
		int id;
		String name;
		int courseId;
		List<Integer> day;
		int timeslot;
		Map<Integer, Integer> batch; // map of day vs number of student (assuming there is one slot per day)
		public boolean addStudent(int batchday) {
			
			if (batch == null){
				batch = new HashMap<Integer, Integer>();
				batch.put(batchday, 1);
			}else if(batch.get(batchday)==null){
				batch.put(batchday, 1);
			}else if(batch.get(batchday)==40) {
				return false;
			}else{
				batch.put(batchday, batch.get(batchday)+1);
			}
			return true;
		}
		public Map<Integer, Integer> getBatch(){
			return batch;
		}
		public void deleteStudent(int batchday){
			batch.put(batchday, batch.get(batchday)-1);
		}
	public boolean getAvailableDay(int batchday){
			if (!day.contains(batchday))return false;
			if (batch==null) return true;
			if (batch.get(batchday) == null) return true;
			if (batch.get(batchday) < 40 ) return true;
			return false;
		}

}
