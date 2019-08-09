package org.brillio.timetable.model;

import java.util.List;

public class Course {
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}

	public List<Integer> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Integer> instructors) {
		this.instructors = instructors;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}
	public void fillSeat(){
		this.availableSeat-=1;
	}
	public void emptySeat(){
		this.availableSeat+=1;
	}
		int id;
		String name;
		String title;
		int unit;

		int totalSeat;
		int availableSeat;
		List<Integer> instructors;
}
