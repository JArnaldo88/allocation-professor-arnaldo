package entity;

import java.time.DayOfWeek;
import java.util.Date;

public class Allocation {
	
	
	private long id;
	private DayOfWeek day;
	private Date start;
	private Date end;
	private long courseId;
	private long professorId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}
	


}
