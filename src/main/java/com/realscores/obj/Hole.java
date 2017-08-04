package com.realscores.obj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hole")
public class Hole implements Serializable {

	private static final long serialVersionUID = 7862178050906377236L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hole_id")
    private int hole_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;
	
	@Column(name="par")
	private int par;
	
	@Column(name="yards")
	private int yards;
	
	@Column(name="number")
	private int holeNumber;

	public int getHoleId() {
		return hole_id;
	}

	public void setHoleId(int hole_id) {
		this.hole_id = hole_id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getYards() {
		return yards;
	}

	public void setYards(int yards) {
		this.yards = yards;
	}

	public int getHoleNumber() {
		return holeNumber;
	}

	public void setHoleNumber(int holeNumber) {
		this.holeNumber = holeNumber;
	}

}
