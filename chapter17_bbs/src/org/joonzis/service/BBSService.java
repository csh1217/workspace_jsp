package org.joonzis.service;

import java.util.List;

import org.joonzis.model.Criteria;
import org.joonzis.vo.BVO;

public interface BBSService {
	//public List<BVO> getList();
	public List<BVO> getListWithPaging(Criteria cri);
	public int getInsertBBS(BVO bvo);
	public BVO getBBS(int b_idx);
	public int removeBBS(int b_idx);
	public int updateBBS(BVO bvo);
	public void updateHit(BVO bvo);
}
