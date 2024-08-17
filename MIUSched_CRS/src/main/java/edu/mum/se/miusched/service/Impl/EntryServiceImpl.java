package edu.mum.se.miusched.service.Impl;

import java.util.List;
import java.util.Optional;

import edu.mum.se.miusched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.se.miusched.dao.EntryDao;
import edu.mum.se.miusched.domain.Entry;
import edu.mum.se.miusched.service.exception.NotFoundException;

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
