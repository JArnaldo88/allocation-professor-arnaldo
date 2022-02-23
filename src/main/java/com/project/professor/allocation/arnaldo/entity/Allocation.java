package com.project.professor.allocation.arnaldo.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="allocation")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column( name="day", nullable = false)
	private DayOfWeek day;
	
	@Temporal(TemporalType.TIME)
	@Column (name = "start", nullable = false)
	private Date start;
	
	@Temporal(TemporalType.TIME)
	@Column (name = "end", nullable = false)
	private Date end;
	
	@Column(name= "courseId", nullable=false)
	private Long courseId;
	
	@ManyToOne(optional = false)
    @JoinColumn ( name = "courseId", updatable = false, insertable = false, nullable = false)
	private Course course;
	
	
	@Column(name = "professorId", nullable = false)
	private Long professorId;
	
	@ManyToOne (optional = false)
	@JoinColumn (name = "professorId", updatable = false, insertable = false, nullable = false)
	private Professor professor;
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", courseId=" + courseId
				+ ", professorId=" + professorId + "]";
	}
	


}
