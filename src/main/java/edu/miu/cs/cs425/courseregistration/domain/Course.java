package edu.miu.cs.cs425.courseregistration.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Lesson> lessons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public Course clone() {
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		return course;
	}
}
