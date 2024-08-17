package edu.mum.se.miusched.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty extends Person {
	
	@OneToMany(mappedBy = "faculty")
	private List<Lesson> lessons;

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}
