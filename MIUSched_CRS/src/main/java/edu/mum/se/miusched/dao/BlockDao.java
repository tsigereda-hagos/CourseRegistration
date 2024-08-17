package edu.mum.se.miusched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.se.miusched.domain.Block;

public interface BlockDao extends JpaRepository<Block, Integer> {

	List<Block> findAllByOrderByYearAscMonthAsc();

}
