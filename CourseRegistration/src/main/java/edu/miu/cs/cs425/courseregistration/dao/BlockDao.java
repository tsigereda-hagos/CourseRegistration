package edu.miu.cs.cs425.courseregistration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.courseregistration.domain.Block;


public interface BlockDao extends JpaRepository<Block, Integer> {

	List<Block> findAllByOrderByYearAscMonthAsc();

}
