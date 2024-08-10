package edu.miu.cs.cs425.courseregistration.services;


import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Block;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;


public interface BlockService {
	void addBlock(Block block);
	Block getBlock(Integer id) throws NotFoundException;
	List<Block> getAllBlocks();
	void deleteBlock(Integer blockId);
	void editBlock(Block block);
}
