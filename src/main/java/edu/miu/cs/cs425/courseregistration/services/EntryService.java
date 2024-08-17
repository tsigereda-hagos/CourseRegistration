package edu.miu.cs.cs425.courseregistration.services;

import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Entry;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;



public interface EntryService {
	void addEntry(Entry entry);
	Entry getEntry(Integer id) throws NotFoundException;
	List<Entry> getAllEntries();
	void deleteEntry(Integer entryId);
	void editEntry(Entry entry);


}
