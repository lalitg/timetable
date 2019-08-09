package org.brillio.timetable;

import java.util.ArrayList;
import java.util.Arrays;

import org.brillio.timetable.repository.CourseRepository;
import org.brillio.timetable.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
	public static void main( String[] args )
	{
		CourseRepository.addCourse(1001, "BIOF110", "BIOLOGY", 5, 100, Arrays.asList(101,102));
		CourseRepository.addCourse(1002, "CHEM112", "CHEMISTRY", 8, 80, Arrays.asList(103,104));
		CourseRepository.addCourse(1003, "CSE312", "COMPUTER SCIENCE", 10, 150, Arrays.asList(105));
		System.out.println(CourseRepository.allCourses);
		InstructorRepository.addInstructor(101, "Aman Garg", 1001,16, Arrays.asList(2));
    	InstructorRepository.addInstructor(102, "Pramod Kumar", 1001,2, Arrays.asList(1));
        InstructorRepository.addInstructor(103, "Neelima Kumari", 1002,10, Arrays.asList(2,4));
        InstructorRepository.addInstructor(104, "S K Kumar", 1002,12, Arrays.asList(1));
        InstructorRepository.addInstructor(105, "Vivek Kumar", 1003,3, Arrays.asList(3,5));
		System.out.println(InstructorRepository.allInstructor);
		SpringApplication.run(App.class, args);
	}
}