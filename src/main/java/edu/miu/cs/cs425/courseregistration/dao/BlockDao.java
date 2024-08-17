package edu.miu.cs.cs425.courseregistration.dao;

import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlockDao extends JpaRepository<Block, Integer> {

	List<Block> findAllByOrderByYearAscMonthAsc();

}
