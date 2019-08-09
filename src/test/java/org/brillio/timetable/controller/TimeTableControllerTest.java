package org.brillio.timetable.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.brillio.timetable.service.CourseServices;
import org.brillio.timetable.service.InstructorServices;
import org.brillio.timetable.service.TimeTableServices;

@RunWith(SpringJUnit4ClassRunner.class)
public class TimeTableControllerTest {

    private MockMvc mockMvc;

    @Mock
	CourseServices courseservice; 
	
    @Mock
	InstructorServices instructorservice;
	
    @Mock
	TimeTableServices timetableservice;

    @InjectMocks
    private TimeTableController currencyController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
    }

    @Test
    public void getAllCourses() throws Exception {
  
        mockMvc.perform(get("/get_courses")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getCourseByDay() throws Exception {
  
        mockMvc.perform(get("/get_available_courses_by_day/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getCourseByInstId() throws Exception {
  
        mockMvc.perform(get("/get_available_courses_by_inst_id/101")
                .contentType(MediaType.APPLICATION_JSON)
                 .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getCourseBySlot() throws Exception {
  
        mockMvc.perform(get("/get_available_courses_by_timeslot/1001")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getInstructor() throws Exception {

        mockMvc.perform(get("/get_Instructor")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getAvailableInstructorByDay() throws Exception {
  
        mockMvc.perform(get("/get_available_instructor_by_day/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getAvailableInstructorByCourse() throws Exception {
  
        mockMvc.perform(get("/get_available_instructor_by_course/1001")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void getAvailableInstructorBySlot() throws Exception {
  
        mockMvc.perform(get("/get_available_instructor_by_timeslot/2")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void saveTimeTable() throws Exception {
  
        mockMvc.perform(get("/save_timetable/1/1001/101/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void addTimeTable() throws Exception {
  
        mockMvc.perform(get("/add_timetable/1/1001/101/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	   @Test
    public void deleteTimeTable() throws Exception {
  
        mockMvc.perform(get("/delete_timetable/1/1001/101/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Basic", "Basic cm9vdDoxMjM0NTY="))
                .andExpect(status().isOk());
    }
	


}
