package com.realscores.obj;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="round")
public class Round implements Serializable {

	private static final long serialVersionUID = 7745335780792154475L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="round_id")
	private int id;
	
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name="course_id")
	private int courseId;
	
	@Column(name="date")
  	private LocalDateTime startTime;
  	
	public int getId() {
	  	return id;
  	}
  
  	public void setId(int id) {
		this.id = id;
	}
	
  	public int getCourseId() {
		return courseId;
	}
	
  	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
  	public LocalDateTime getStartTime() {
		return startTime;
	}
	
  	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
}

