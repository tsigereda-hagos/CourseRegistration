package edu.miu.cs.cs425.courseregistration.domain;

import edu.miu.cs.cs425.courseregistration.Utils.Utils;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "block")
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "block_id")
	private Integer id;
	
	@Column(name = "`month`")
	private Integer month;
	
	@Column(name ="`year`")
	private Integer year;

	@OneToMany(mappedBy = "block")
	private List<Lesson> lessons;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Transient
	public String getName() {
		return Utils.getMonth(month) + " " + year;
	}

	@Transient
	@Override
	public String toString() {
		return getName() + " (" + lessons.size() + " lessons)";
	}
	
	@Transient
	public Block clone() {
		Block block = new Block();
		block.setId(id);
		block.setMonth(month);
		block.setYear(year);
		return block;
	}
}
