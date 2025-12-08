package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class CommentServiceImpl implements CommentService{
	private CDao cDao = CDaoImpl.getInstance();

	@Override
	public int insertComment(CVO cvo) {
		return cDao.insertComment(cvo);
	}

	@Override
	public List<CVO> getCommList(int b_idx) {
		return cDao.getCommList(b_idx);
	}

	@Override
	public void removeComment(int c_idx) {
		// TODO Auto-generated method stub
		cDao.removeComment(c_idx);
	}

	
	
}
