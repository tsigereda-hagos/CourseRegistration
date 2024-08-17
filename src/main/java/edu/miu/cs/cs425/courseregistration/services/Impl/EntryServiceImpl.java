package edu.miu.cs.cs425.courseregistration.services.Impl;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs425.courseregistration.dao.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.courseregistration.domain.Entry;
import edu.miu.cs.cs425.courseregistration.services.EntryService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;


@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryDao entryDao;

	@Override
	public void addEntry(Entry entry) {
		entryDao.save(entry);
	}

	@Override
	public Entry getEntry(Integer id) throws NotFoundException {
		Optional<Entry> entry = entryDao.findById(id);

		if(entry.isEmpty())
			throw new NotFoundException("No entry with id " + id + " found.");

		return entry.get();
	}

	@Override
	public List<Entry> getAllEntries() {
		//return entryDao.findAll();
		return entryDao.findAllByOrderByYearAscMonthAsc();
	}

	@Override
	public void deleteEntry(Integer entryId) {
		entryDao.deleteById(entryId);

	}

	@Override
	public void editEntry(Entry entry) {
		addEntry(entry);
	}

}
