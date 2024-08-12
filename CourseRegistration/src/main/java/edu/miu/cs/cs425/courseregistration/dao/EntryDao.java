package edu.miu.cs.cs425.courseregistration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.courseregistration.domain.Entry;


@Repository
public interface EntryDao extends JpaRepository<Entry, Integer> {
	List<Entry> findAllByOrderByYearAscMonthAsc();
}
