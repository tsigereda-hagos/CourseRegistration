package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Block;
import edu.mum.se.miusched.service.exception.NotFoundException;

public interface BlockService {
	void addBlock(Block block);
	Block getBlock(Integer id) throws NotFoundException;
	List<Block> getAllBlocks();
	void deleteBlock(Integer blockId);
	void editBlock(Block block);
}
