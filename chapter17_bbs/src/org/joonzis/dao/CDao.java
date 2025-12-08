package org.joonzis.dao;

import java.util.List;

import org.joonzis.vo.CVO;

public interface CDao {
	public int insertComment(CVO cvo);
	public List<CVO> getCommList(int b_idx);
	public void removeComment(int c_idx);

}
