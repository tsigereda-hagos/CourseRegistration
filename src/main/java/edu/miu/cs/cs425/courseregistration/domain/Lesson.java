package edu.miu.cs.cs425.courseregistration.domain;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name="block_id")
	private Block block;
	
	@OneToMany(mappedBy = "lesson")
	private List<StudentLesson> studentLessons;
	
	/*@ManyToMany
	@JoinTable(
	  name = "student_lesson", 
	  joinColumns = @JoinColumn(name = "lesson_id"), 
	  inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<StudentLesson> getStudentLessons() {
		return studentLessons;
	}

	public void setStudentLessons(List<StudentLesson> studentLessons) {
		this.studentLessons = studentLessons;
	}

	@Transient
	@Override
	public String toString() {
		return new StringBuilder()
				.append(id).append(", ")
				.append(faculty.getFirstName()).append(" ").append(faculty.getLastName()).append(", ")
				.append(course.getName()).append(", ")
				.append(block.getName()).toString();
	}
}
