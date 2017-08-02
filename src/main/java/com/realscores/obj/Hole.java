package com.realscores.obj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private int id;
	
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name="course_id")
	private int courseId;
	
	@Column(name="par")
	private int par;
	
	@Column(name="yards")
	private int yards;
	
	@Column(name="number")
	private int holeNumber;

}
